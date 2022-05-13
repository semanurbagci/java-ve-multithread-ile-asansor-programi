package yazlab1proje2;

public class kontrol implements Runnable{
	
	asansor1 a1 = new asansor1();
	Thread a_t1 = new Thread(a1);
	asansor2 a2 = new asansor2();
	Thread a_t2 = new Thread(a2);
	asansor3 a3 = new asansor3();
	Thread a_t3 = new Thread(a3);
	asansor4 a4 = new asansor4();
	Thread a_t4 = new Thread(a4);
	
	int sayac1=-1;
	int sayac2=-1;
	int sayac3=-1;
	int sayac4=-1;
	
	int kuyrukAsýldý = 0;
	
	boolean kuyrukAsýmý() {
		int kuyrukToplam = giris.kuyruk.size()+cikis.kuyruk1.size()+cikis.kuyruk2.size()+cikis.kuyruk3.size()+cikis.kuyruk4.size();
		if(kuyrukToplam>20) {
			return true;
		}
		return false;
	}
	
	boolean kuyrukAzaldý() {
		int kuyrukToplam = giris.kuyruk.size()+cikis.kuyruk1.size()+cikis.kuyruk2.size()+cikis.kuyruk3.size()+cikis.kuyruk4.size();
		if(kuyrukToplam<10) {
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	@Override						
	public void run() {
		int i=0;
		while(i==0) {						//sayac=-1, asansor hiç çalýþmamýþ  sayac=1, þu an çalýþýyor  sayac=0, beklemeye alýnmýþ 
			if(kuyrukAsýmý()==true) {
				//System.out.println("KUYRUK ASIMI");
				kuyrukAsýldý=1;
				if(sayac1!=1) { //kuyruk aþýmý var ve asansor1 çalýþmýyorsa þu an..
					if(sayac1==-1) { //asansor1 daha hiç çalýþmamýþ..
						asansor1.aktifMi=1;
						a_t1.start();
						System.out.println("ASANSOR1 CALISTIRILDI..\n");
						sayac1=1; //asansor1 start edildi, sayac1 1 yapýldý.
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(sayac1==0) { //asansor çalýþtýrýlýp durdurulmuþ.
						Thread a_t1 = new Thread(a1);
						asansor1.aktifMi=1;
						a_t1.start();
						System.out.println("ASANSOR1 TEKRAR CALISTIRILDI..\n");
						sayac1=1;  //asansor tekrar çalýþtýrýlsýn, sayac 1 yapýldý..
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				else if(sayac2!=1) { //ayný iþlemler tekrarlanýyor..
					if(sayac2==-1) {
						asansor2.aktifMi=1;
						a_t2.start();
						System.out.println("ASANSOR2 CALISTIRILDI..\n");
						sayac2=1;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(sayac2==0){
						Thread a_t2 = new Thread(a2);
						asansor2.aktifMi=1;
						a_t2.start();
						System.out.println("ASANSOR2 TEKRAR CALISTIRILDI..\n");
						sayac2=1;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				else if(sayac3!=1) {
					if(sayac3==-1) {
						asansor3.aktifMi=1;
						a_t3.start();
						System.out.println("ASANSOR3 CALISTIRILDI..\n");
						sayac3=1;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(sayac3==0) {
						Thread a_t3 = new Thread(a3);
						asansor3.aktifMi=1;
						a_t3.start();
						System.out.println("ASANSOR3 TEKRAR CALISTIRILDI..\n");
						sayac3=1;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				else if(sayac4!=1) {
					if(sayac4==-1) {
						asansor4.aktifMi=1;
						a_t4.start();
						System.out.println("ASANSOR4 CALISTIRILDI..\n");
						sayac4=1;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(sayac4==0) {
						Thread a_t4 = new Thread(a4);
						asansor4.aktifMi=1;
						a_t4.start();
						System.out.println("ASANSOR4 TEKRAR CALISTIRILDI..\n");
						sayac4=1;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
				
			else if(kuyrukAsýldý==1 && kuyrukAzaldý()==true) {
				kuyrukAsýldý=0;
				//System.out.println("KUYRUK AZALDI");
				if(sayac4==1) { //asansor þu an çalýþýyorsa..
					asansor4.aktifMi=0;
					a_t4.stop();
					System.out.println("ASANSOR4 DURDURULDU..\n");
					sayac4=0; //durdur, sayac=0 yap
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(sayac3==1) {
					asansor3.aktifMi=0;
					a_t3.stop();
					System.out.println("ASANSOR3 DURDURULDU..\n");
					sayac3=0;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(sayac2==1) {
					asansor2.aktifMi=0;
					a_t2.stop();
					System.out.println("ASANSOR2 DURDURULDU..\n");
					sayac2=0;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(sayac1==1) {
					asansor1.aktifMi=0;
					a_t1.stop();
					System.out.println("ASANSOR1 DURDURULDU..\n");
					sayac1=0;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}

}
