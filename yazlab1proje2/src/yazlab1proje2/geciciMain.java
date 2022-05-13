package yazlab1proje2;

public class geciciMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		giris a = new giris();
		cikis b = new cikis();
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
		
		asansor0 c = new asansor0();
		Thread t3 = new Thread(c);
		t3.start();
		
		kontrol d = new kontrol();
		Thread t4 = new Thread(d);
		t4.start();
		
	}
	

}