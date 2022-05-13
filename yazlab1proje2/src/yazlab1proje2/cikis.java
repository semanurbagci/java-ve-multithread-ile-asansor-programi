package yazlab1proje2;


import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class cikis implements Runnable{
	
	static BlockingQueue<Integer> kuyruk1 = new ArrayBlockingQueue<>(500);
	static BlockingQueue<Integer> kuyruk2 = new ArrayBlockingQueue<>(500);
	static BlockingQueue<Integer> kuyruk3 = new ArrayBlockingQueue<>(500);
	static BlockingQueue<Integer> kuyruk4 = new ArrayBlockingQueue<>(500);
	
	static int kattaBulKisiSayisi1=0;
	static int kattaBulKisiSayisi2=0;
	static int kattaBulKisiSayisi3=0;
	static int kattaBulKisiSayisi4=0;
	
	int kisiSayisi() {
		Random rnd = new Random();
		int kisiSayisi = rnd.nextInt(10)+1;
		return kisiSayisi;
	}
	
	int katNo() {
		Random rnd = new Random();
		int katNo = rnd.nextInt(4)+1;
		return katNo;
	}
	

	
	@Override
	public void run() {
		
int sayac=0;
		
		while(sayac<10) {
		
			int kisi=kisiSayisi();
			int kat=katNo();
		
			try {
				
				if(kat==1) {
					for(int i=0;i<kisi;i++) {
						kuyruk1.put(0);
					}
					sayac++;
				}
				else if(kat==2) {
					for(int i=0;i<kisi;i++) {
						kuyruk2.put(0);
					}
					sayac++;
				}
				else if(kat==3) {
					for(int i=0;i<kisi;i++) {
						kuyruk3.put(0);
					}
					sayac++;
				}
				else if(kat==4) {
					for(int i=0;i<kisi;i++) {
						kuyruk3.put(0);
					}
					sayac++;
				}
						
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
		}
		

			
	}
	

}