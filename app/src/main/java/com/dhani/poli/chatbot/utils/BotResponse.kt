package com.dhani.poli.chatbot.utils

object BotResponse {

    fun basicResponse(_message:String):String{
        val random = (0..2).random()
        val message = _message.toLowerCase()

        return when{
            //hello
            message.contains("halo")->{
                when(random){
                    0 -> "Halo !"
                    1 -> "Hai !"
                    2 -> "Hello !"
                    else -> "Maaf saya tidak mengerti"
                }
            }

            //apa kabar
            message.contains("apa kabar")->{
                when(random){
                    0 -> "Baik, ada yang bisa dibantu"
                    1 -> "Baik"
                    2 -> "Baik"
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("siapa sekretaris teknik informatika")->{
                when(random){
                    0 -> "Untuk sekretaris D4 Teknik Informatika dijabat oleh Bapak M. Fikri Hidayattullah S.T. M.Kom."
                    1 -> "Untuk sekretaris D4 Teknik Informatika dijabat oleh Bapak M. Fikri Hidayattullah S.T. M.Kom."
                    2 -> "Untuk sekretaris D4 Teknik Informatika dijabat oleh Bapak M. Fikri Hidayattullah S.T. M.Kom."
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("ruang perpustakaan")->{
                when(random){
                    0 -> "Ruang Perpustakaan ada di gedung D lantai 1 politeknik harapan bersama."
                    1 -> "Ruang Perpustakaan ada di gedung D lantai 1 politeknik harapan bersama."
                    2 -> "Ruang Perpustakaan ada di gedung D lantai 1 politeknik harapan bersama."
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("ruang dosen")->{
                when(random){
                    0 -> "Ruang dosen ada di gedung D lantai 2 politeknik harapan bersama."
                    1 -> "Ruang dosen ada di gedung D lantai 2 politeknik harapan bersama."
                    2 -> "Ruang dosen ada di gedung D lantai 2 politeknik harapan bersama."
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("study club")->{
                when(random){
                    0 -> "Ada beberapa study club yang ada di prodi kita seperti Plugin, Hackme, WM SMIT"
                    1 -> "Ada beberapa study club yang ada di prodi kita seperti Plugin, Hackme, WM SMIT"
                    2 -> "Ada beberapa study club yang ada di prodi kita seperti Plugin, Hackme, WM SMIT"
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("organisasi apa saja")->{
                when(random){
                    0 -> "Ada 3 orginasi yang ada yaitu himpunan Mahasiswa himpunan Alumni dan study club."
                    1 -> "Ada 3 orginasi yang ada yaitu himpunan Mahasiswa himpunan Alumni dan study club."
                    2 -> "Ada 3 orginasi yang ada yaitu himpunan Mahasiswa himpunan Alumni dan study club."
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("cara membayar spp")->{
                when(random){
                    0 -> "Untuk tutorialnya kamu diharuskan login ke dalam akun oase kamu lalu masuk ke bagian keranjang."
                    1 -> "Untuk tutorialnya kamu diharuskan login ke dalam akun oase kamu lalu masuk ke bagian keranjang."
                    2 -> "Untuk tutorialnya kamu diharuskan login ke dalam akun oase kamu lalu masuk ke bagian keranjang."
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("apa saja fasilitas yang ada")->{
                when(random){
                    0 -> "Laboratorium RnD  Laboratorium Komputer D1 Laboratorium Komputer D2 Laboratorium Hardware."
                    1 -> "Laboratorium RnD  Laboratorium Komputer D1 Laboratorium Komputer D2 Laboratorium Hardware."
                    2 -> "Laboratorium RnD  Laboratorium Komputer D1 Laboratorium Komputer D2 Laboratorium Hardware."
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("nomor kontak admin")->{
                when(random){
                    0 -> "Hai berikut kontak whatsapp admin prodi D4 Teknik Informatika yang bisa dihubungi (+62 858-6886-6067)"
                    1 -> "Hai berikut kontak whatsapp admin prodi D4 Teknik Informatika yang bisa dihubungi (+62 858-6886-6067)"
                    2 -> "Hai berikut kontak whatsapp admin prodi D4 Teknik Informatika yang bisa dihubungi (+62 858-6886-6067)"
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("apa itu teknik informatika")->{
                when(random){
                    0 -> "Teknik informatika merupakan bidang ilmu  yang mempelajari teknologi komputer meliputi analisis matematis pengembangan pengujian evaluasi perangkat lunak (software) sistem operasi dan kerja komputer."
                    1 -> "Teknik informatika merupakan bidang ilmu  yang mempelajari teknologi komputer meliputi analisis matematis pengembangan pengujian evaluasi perangkat lunak (software) sistem operasi dan kerja komputer."
                    2 -> "Teknik informatika merupakan bidang ilmu  yang mempelajari teknologi komputer meliputi analisis matematis pengembangan pengujian evaluasi perangkat lunak (software) sistem operasi dan kerja komputer."
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("siapa kepala prodi teknik informatika")->{
                when(random){
                    0 -> "Untuk Kepala Prodi D4 Teknik Informatika dijabat oleh Bpk Slamet Wiyono S.Pd. M.Eng"
                    1 -> "Bpk Slamet Wiyono S.Pd. M.Eng"
                    2 -> "Untuk Kepala Prodi D4 Teknik Informatika dijabat oleh Bpk Slamet Wiyono S.Pd. M.Eng"
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("politeknik harapan bersama")->{
                when(random){
                    0 -> "Politeknik Harapan Bersama adalah perguruan tinggi swasta yang berkedudukan di Kota Tegal Jawa Tengah. Perguruan tinggi ini didirikan pada tahun 2002 berdasarkan Surat Keputusan Menteri Pendidikan Nasional Nomor 128/D/O/2002."
                    1 -> "Politeknik Harapan Bersama adalah perguruan tinggi swasta yang berkedudukan di Kota Tegal Jawa Tengah. Perguruan tinggi ini didirikan pada tahun 2002 berdasarkan Surat Keputusan Menteri Pendidikan Nasional Nomor 128/D/O/2002."
                    2 -> "Politeknik Harapan Bersama adalah perguruan tinggi swasta yang berkedudukan di Kota Tegal Jawa Tengah. Perguruan tinggi ini didirikan pada tahun 2002 berdasarkan Surat Keputusan Menteri Pendidikan Nasional Nomor 128/D/O/2002."
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("apa itu poli")->{
                when(random){
                    0 -> "Poli adalah asisten virtual yang akan membantu kamu untuk menjawab semua hal yang berhubungan dengan Prodi Teknik Informatika."
                    1 -> "Poli adalah asisten virtual yang akan membantu kamu untuk menjawab semua hal yang berhubungan dengan Prodi Teknik Informatika."
                    2 -> "Poli adalah asisten virtual yang akan membantu kamu untuk menjawab semua hal yang berhubungan dengan Prodi Teknik Informatika."
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("akreditasi teknik informatika")->{
                when(random){
                    0 -> "Akreditasi prodi D4 Teknik Informatika adalah B."
                    1 -> "Akreditasi prodi D4 Teknik Informatika adalah B."
                    2 -> "Akreditasi prodi D4 Teknik Informatika adalah B."
                    else -> "Maaf saya tidak mengerti"
                }
            }

            message.contains("alamat politeknik harapan bersama")->{
                when(random){
                    0 -> "Jl. Mataram No.9 Kel. pesurungan lor Kel. Pesurungan Lor Pesurungan Lor Margadana Kota Tegal Jawa Tengah."
                    1 -> "Jl. Mataram No.9 Kel. pesurungan lor Kel. Pesurungan Lor Pesurungan Lor Margadana Kota Tegal Jawa Tengah."
                    2 -> "Jl. Mataram No.9 Kel. pesurungan lor Kel. Pesurungan Lor Pesurungan Lor Margadana Kota Tegal Jawa Tengah."
                    else -> "Maaf saya tidak mengerti"
                }
            }

            else -> {
                when(random){
                    0 -> "Saya tidak mengerti"
                    1 -> "Maaf, saya tidak mengerti"
                    2 -> "Saya tidak mengerti maksud anda"
                    else -> "Maaf saya tidak mengerti"
                }
            }
        }
    }
}