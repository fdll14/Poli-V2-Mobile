package com.dhani.poli.chatbot.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dhani.poli.R
import com.dhani.poli.api.response.Default
import com.dhani.poli.chatbot.data.message
import com.dhani.poli.chatbot.utils.BotResponse
import com.dhani.poli.chatbot.utils.Constants.RECEIVE_ID
import com.dhani.poli.chatbot.utils.Constants.SEND_ID
import com.dhani.poli.chatbot.utils.Time
import kotlinx.android.synthetic.main.activity_chatbot.*
import kotlinx.android.synthetic.main.activity_gender_detect.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Response

class ChatbotActivity : AppCompatActivity() {

    private lateinit var adapter : MessagingAdapter
    private val botList = listOf("Poli")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)

        val actionbar = supportActionBar
        actionbar!!.title = "CHATBOT POLI"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        recyclerView()

        clickEvents()

        val random = (0..3).random()

        customMessage("Halo saya ${botList}, apa yang ingin anda tanyakan ?")
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun clickEvents(){
        btn_send.setOnClickListener {
            sendMessage()
        }
        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(100)
                withContext(Dispatchers.Main){
                    rv_messages.scrollToPosition(adapter.itemCount-1)
                }
            }
        }
    }

    private fun recyclerView(){
        adapter = MessagingAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun sendMessage(){
        val message = et_message.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()){
            et_message.setText("")

            adapter.insertMessage(message(message, SEND_ID, timeStamp))
            rv_messages.scrollToPosition(adapter.itemCount-1)

            botResponse(message)
        }
    }

    private fun botResponse(message: String){
        val timeStamp = Time.timeStamp()

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                val response = BotResponse.basicResponse(message)

                adapter.insertMessage(message(response, RECEIVE_ID, timeStamp))
                rv_messages.scrollToPosition(adapter.itemCount-1)

            }
        }

    }

    override fun onStart() {
        super.onStart()

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                rv_messages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }

    private fun customMessage(message: String){
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                val timeStamp = Time.timeStamp()
                adapter.insertMessage(message(message, RECEIVE_ID, timeStamp))

                rv_messages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }
}