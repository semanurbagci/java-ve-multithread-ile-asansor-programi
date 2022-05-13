package yazlab1proje2;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class giris implements Runnable{
	
	static BlockingQueue<Integer> kuyruk = new ArrayBlockingQueue<>(500);
	static int zemindeBulKisiSayisi=0;
	
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

				for(int i=0;i<kisi;i++) {
				kuyruk.put(kat);
				}
				sayac++;
				Thread.sleep(500);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
		
	}