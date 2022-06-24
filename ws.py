# NAMA ANGGOTA KELOMPOK 
# Muhamad Shuro Fadhillah (19090072) (6D)
# Ramadhani Fauzi Azhar (19090118) (6D)


import numpy as np
import keras
from keras.models import Sequential
from keras.layers import Dense,Conv2D,MaxPool2D,Dropout,BatchNormalization,Flatten,Activation
from keras.preprocessing import image 
from keras.preprocessing.image import ImageDataGenerator
# import matplotlib.pyplot as plt
from keras.utils.vis_utils import plot_model
import pickle
from flask import Flask, jsonify,request,flash,redirect,render_template, session,url_for
#from flask_session import Session
from itsdangerous import json
from werkzeug.utils import secure_filename
import os
from flask_cors import CORS
from flask_restful import Resource, Api
import pymongo
import re
import datetime
import random
import string
from PIL import Image
from datetime import date

app = Flask(__name__)
#sess = Session()
UPLOAD_FOLDER = 'fotogender'
ALLOWED_EXTENSIONS = set(['png', 'jpg', 'jpeg'])
app.config['MAX_CONTENT_LENGTH'] = 16 * 1024 * 1024
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

app.secret_key = "bp"
# #SECRET_KEY = 'xxxxxxxxx'
# #app.config['SESSION_TYPE'] = 'filesystem'
MONGO_ADDR = 'mongodb://localhost:27017'
MONGO_DB = "BogProV2"

conn = pymongo.MongoClient(MONGO_ADDR)
db = conn[MONGO_DB]

api = Api(app)
CORS(app)

from tensorflow.keras.models import load_model
MODEL_PATH = 'model_fix.h5'
model = load_model(MODEL_PATH,compile=False)

pickle_inn = open('num_class_gender.pkl','rb')
num_classes_bird = pickle.load(pickle_inn)

def allowed_file(filename):     
  return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

class index(Resource):
  def post(self):

    if 'image' not in request.files:
      flash('No file part')
      return jsonify({
            "pesan":"tidak ada form image"
          })
    file = request.files['image']
    if file.filename == '':
      return jsonify({
            "pesan":"tidak ada file image yang dipilih"
          })
    if file and allowed_file(file.filename):
      path_del = r"fotogender\\"
      for file_name in os.listdir(path_del):
        file_del = path_del + file_name
        if os.path.isfile(file_del):
            print('Deleting file:', file_del)
            os.remove(file_del)
            print("file "+file_del+" telah terhapus")
      filename = secure_filename(file.filename)
      file.save(os.path.join(app.config['UPLOAD_FOLDER'], filename))
      path=("fotogender/"+filename)
      today = date.today()
      db.history.insert_one({'nama_file': filename, 'path': path, 'prediksi':'No predict', 'akurasi':0, 'tanggal':today.strftime("%d/%m/%Y")})

      #def predict(dir):
      img=keras.utils.load_img(path,target_size=(224,224))
      img1=keras.utils.img_to_array(img)
      img1=img1/255
      img1=np.expand_dims(img1,[0])
      predict=model.predict(img1)
      classes=np.argmax(predict,axis=1)
      for key,values in num_classes_bird.items():
          if classes==values:
            accuracy = float(round(np.max(model.predict(img1))*100,2))
            db.history.update_one({'nama_file': filename}, 
              {"$set": {
                'prediksi': str(key), 
                'akurasi':accuracy
              }
              })

            if accuracy >75:
              print("hasil prediksi jenis_kelamin : "+str(key)+" with a probability of "+str(accuracy)+"%")
        
              return jsonify({
                "gender":str(key),
                "Accuracy":str(accuracy)+"%",        
                
              })
            else :
              print("The predicted image of the gender is: "+str(key)+" with a probability of "+str(accuracy)+"%")
              return jsonify({
                "Message":str("Jenis kelamin tidak terdeteksi"),
                "Accuracy":str(accuracy)+"%"               
                
              })
              
    else:
      return jsonify({
        "Message":"bukan file image"
      })


@app.route('/riwayat')
def riwayat():
    dataRiwayat = db['history'].find({})
    print(dataRiwayat)
    return render_template('riwayat.html',riwayat  = dataRiwayat)


api.add_resource(index, "/api/image", methods=["POST"])

if __name__ == '__main__':
  

  app.run(debug = True, port=5000, host='0.0.0.0')

