package com.example.klinikvokasi15902;

import android.app.Application;

public class ApplicationData extends Application{
    private String[] txtGeneralSet = new String[17];

    synchronized public void setSelectedLocation(String location){txtGeneralSet[0] = location;}
    synchronized public String getSelectedLocation(){return txtGeneralSet[0];}

    synchronized public void setLocationAddress(String locationAddress){txtGeneralSet[1] = locationAddress;}
    synchronized public String getLocationAddress(){return txtGeneralSet[1];}

    synchronized public void setDokterName(String name){txtGeneralSet[2] = name;}
    synchronized public String getDokterName(){return txtGeneralSet[2];}

    synchronized public void setWaktuKunjungan(String waktu){txtGeneralSet[3] = waktu;}
    synchronized public String getWaktuKunjungan(){return txtGeneralSet[3];}

    synchronized public void setJamKunjungan(String waktu){txtGeneralSet[4] = waktu;}
    synchronized public String getJamKunjungan(){return txtGeneralSet[4];}

    synchronized public void setNamaPengunjung(String nama){txtGeneralSet[5] = nama;}
    synchronized public String getNamaPengunjung(){return txtGeneralSet[5];}

    synchronized public void setKelamin(String nama){txtGeneralSet[16] = nama;}
    synchronized public String getKelamin(){return txtGeneralSet[16];}

    synchronized public void setNIKPengunjung(String nik){txtGeneralSet[6] = nik;}
    synchronized public String getNIKPengunjung(){return txtGeneralSet[6];}

    synchronized public void setProvinsiPengunjung(String provinsi){txtGeneralSet[7] = provinsi;}
    synchronized public String getProvinsiPengunjung(){return txtGeneralSet[7];}

    synchronized public void setTeleponPengunjung(String telp){txtGeneralSet[8] = telp;}
    synchronized public String getTeleponPengunjung(){return txtGeneralSet[8];}

    synchronized public void setBeratBadan(String value){txtGeneralSet[9] = value;}
    synchronized public String getBeratBadan(){return txtGeneralSet[9];}

    synchronized public void setTinggiBadan(String value){txtGeneralSet[10] = value;}
    synchronized public String getTinggiBadan(){return txtGeneralSet[10];}

    synchronized public void setTekananDarah(String value){txtGeneralSet[11] = value;}
    synchronized public String getTekananDarah(){return txtGeneralSet[11];}

    synchronized public void setAlergiObat(String value){txtGeneralSet[12] = value;}
    synchronized public String getAlergiObat(){return txtGeneralSet[12];}

    synchronized public void setKeluhan(String value){txtGeneralSet[13] = value;}
    synchronized public String getKeluhan(){return txtGeneralSet[13];}

    synchronized public void setMetodePembayaran(String value){txtGeneralSet[14] = value;}
    synchronized public String getMetodePembayaran(){return txtGeneralSet[14];}

    synchronized public void setNoAsuransi(String value){txtGeneralSet[15] = value;}
    synchronized public String getNoAsuransi(){return txtGeneralSet[15];}
}
