package yazlab1proje2;

public class asansor4 implements Runnable{
	
	giris g = new giris();
	cikis c = new cikis();
	
	static int aktifMi = 1; 
	
	void asansorYazdir(String s, int bulunKat, int hedefKat, String yon, int icindekiKisiSayisi, int kapasite, int aktiflik) {
		System.out.println(s+":");
		System.out.println("bulundugu kat: "+bulunKat);
		System.out.println("hedef kat: "+hedefKat);
		System.out.println("ilerleme yonu: "+yon);
		System.out.println("asansordeki kisi sayisi: "+icindekiKisiSayisi);
		System.out.println("asansorun kapasitesi: "+kapasite);
		if(aktiflik==1) {
			System.out.println("asansor durumu: ACTIVE");
		}
		else if(aktiflik==0) {
			System.out.println("asansor durumu: ACTIVE DEGIL");
		}
	}
	
	static void katGuncelle(int a, int b) {
		if(a==0) {
			giris.zemindeBulKisiSayisi+=b;
		}
		else if(a==1) {
			cikis.kattaBulKisiSayisi1+=b;
		}
		else if(a==2) {
			cikis.kattaBulKisiSayisi2+=b;
		}
		else if(a==3) {
			cikis.kattaBulKisiSayisi3+=b;
		}
		else if(a==4) {
			cikis.kattaBulKisiSayisi4+=b;
		}
	}
	
	static void katlariYazdir() {
		System.out.println("zemin kattaki kisi sayisi: "+giris.zemindeBulKisiSayisi);
		System.out.println("zemin katta sirada bekleyen kisi sayisi: "+giris.kuyruk.size());
		
		System.out.println("birinci kattaki kisi sayisi: "+cikis.kattaBulKisiSayisi1);
		System.out.println("birinci katta sirada bekleyen kisi sayisi: "+cikis.kuyruk1.size());
		
		System.out.println("ikinci kattaki kisi sayisi: "+cikis.kattaBulKisiSayisi2);
		System.out.println("ikinci katta sirada bekleyen kisi sayisi: "+cikis.kuyruk2.size());
		
		System.out.println("ucuncu kattaki kisi sayisi: "+cikis.kattaBulKisiSayisi3);
		System.out.println("ucuncu katta sirada bekleyen kisi sayisi: "+cikis.kuyruk3.size());
		
		System.out.println("dorduncu kattaki kisi sayisi: "+cikis.kattaBulKisiSayisi4);
		System.out.println("dorduncu katta sirada bekleyen kisi sayisi: "+cikis.kuyruk4.size());
		
		System.out.println("-----------------------------------\n");
	}
	
	@Override
	public void run() {
		
		int asansorBulKat=0;
		int gidilecekKat = 0;
		int kisiSayac=0;
		int tempKat=-1;
		
		String ad = new String();
		int bulunKat;
		int hedefKat;
		String yon = new String();
		int icindekiKisi = 0;
		
		while(true) {
			synchronized (g) {
				if(asansorBulKat==0 && giris.kuyruk.size()>0) { //0'dan yukari cikilacak.
					gidilecekKat=giris.kuyruk.peek();
					tempKat=giris.kuyruk.peek();
					while(tempKat==gidilecekKat && kisiSayac<10) {
						giris.kuyruk.remove();						
						kisiSayac++;
						if(giris.kuyruk.size()>0) {
							tempKat=giris.kuyruk.peek();
						}
						else {
							break;
						}
					}
					
					ad = "ASANSOR4";
					bulunKat = asansorBulKat;
					hedefKat= gidilecekKat;
					yon = "yukari";
					icindekiKisi = kisiSayac;
					asansorYazdir(ad, asansorBulKat, gidilecekKat, yon, icindekiKisi, 10, aktifMi);
					katGuncelle(hedefKat, kisiSayac);
					katlariYazdir();
					
					asansorBulKat=gidilecekKat;
					kisiSayac=0;
					tempKat=-1;
					gidilecekKat=0;
					try {
						Thread.sleep(gidilecekKat*200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			synchronized (c) {
				if(asansorBulKat==1 && cikis.kuyruk1.size()>0) { //1'den 0'a inilecek.
					if(cikis.kuyruk1.size()<=10) {
						int tutBoyut=cikis.kuyruk1.size();
						for(int j=0; j<tutBoyut; j++) {
							cikis.kuyruk1.remove();
							kisiSayac++;
						}
					}
					else {
						for(int j=0; j<10; j++) {
							cikis.kuyruk1.remove();
							kisiSayac++;
						}
					}
					
					ad = "ASANSOR4";
					bulunKat = asansorBulKat;
					hedefKat= gidilecekKat;
					yon = "asagi";
					icindekiKisi = kisiSayac;
					asansorYazdir(ad, asansorBulKat, gidilecekKat, yon, icindekiKisi, 10, aktifMi);
					katGuncelle(hedefKat, kisiSayac);
					katlariYazdir();
					
					asansorBulKat=0;
					kisiSayac=0;
					try {
						Thread.sleep(asansorBulKat*200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(asansorBulKat==2 && cikis.kuyruk2.size()>0) { //2'den 0'a inilecek.
					if(cikis.kuyruk2.size()<=10) {
						int tutBoyut=cikis.kuyruk2.size();
						for(int j=0; j<tutBoyut; j++) {
							cikis.kuyruk2.remove();
							kisiSayac++;
						}
					}
					else {
						for(int j=0; j<10; j++) {
							cikis.kuyruk2.remove();
							kisiSayac++;
						}
					}
					
					ad = "ASANSOR4";
					bulunKat = asansorBulKat;
					hedefKat= gidilecekKat;
					yon = "asagi";
					icindekiKisi = kisiSayac;
					asansorYazdir(ad, asansorBulKat, gidilecekKat, yon, icindekiKisi, 10, aktifMi);
					katGuncelle(hedefKat, kisiSayac);
					katlariYazdir();
					
					asansorBulKat=0;
					kisiSayac=0;
					try {
						Thread.sleep(asansorBulKat*200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(asansorBulKat==3 && cikis.kuyruk3.size()>0) { //3'ten 0'a inilecek.
					if(cikis.kuyruk3.size()<=10) {
						int tutBoyut=cikis.kuyruk3.size();
						for(int j=0; j<tutBoyut; j++) {
							cikis.kuyruk3.remove();
							kisiSayac++;
						}
					}
					else {
						for(int j=0; j<10; j++) {
							cikis.kuyruk3.remove();
							kisiSayac++;
						}
					}

					ad = "ASANSOR4";
					bulunKat = asansorBulKat;
					hedefKat= gidilecekKat;
					yon = "asagi";
					icindekiKisi = kisiSayac;
					asansorYazdir(ad, asansorBulKat, gidilecekKat, yon, icindekiKisi, 10, aktifMi);
					katGuncelle(hedefKat, kisiSayac);
					katlariYazdir();
					
					asansorBulKat=0;
					kisiSayac=0;
					try {
						Thread.sleep(asansorBulKat*200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(asansorBulKat==4 && cikis.kuyruk4.size()>0) { //4'den 0'a inilecek.
					if(cikis.kuyruk4.size()<=10) {
						int tutBoyut=cikis.kuyruk4.size();
						for(int j=0; j<tutBoyut; j++) {
							cikis.kuyruk4.remove();
							kisiSayac++;
						}
					}
					else {
						for(int j=0; j<10; j++) {
							cikis.kuyruk4.remove();
							kisiSayac++;
						}
					}

					ad = "ASANSOR4";
					bulunKat = asansorBulKat;
					hedefKat= gidilecekKat;
					yon = "asagi";
					icindekiKisi = kisiSayac;
					asansorYazdir(ad, asansorBulKat, gidilecekKat, yon, icindekiKisi, 10, aktifMi);
					katGuncelle(hedefKat, kisiSayac);
					katlariYazdir();
					
					asansorBulKat=0;
					kisiSayac=0;
					try {
						Thread.sleep(asansorBulKat*200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
	
	
	
}