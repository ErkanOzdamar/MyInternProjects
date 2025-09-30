#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <windows.h>
#include <time.h>

//[genel bilgiler]:


//int a;       tam sayı atar(1 2 3 4 5 -1 -2 -3 -4)
//            girdi veya çıktı vermek için %d kullanılır.

//double a;         virgülden sonra 6 basamak gösterir %lf girdi çıktı alırken kullanılır
//printf("%.4lf");  .4 kullanarak göstereceği basamak sınırlanabilir.

//float a;         virgülden sonra 6 basamak gösterir yukardaki kural yine geçerlidir.

//1) \n == yeni satıra geçer.

//2) \t == kelimeler arası 3 boşluk bırakır(bir sonraki tab başlangıcana taşır).

//3) \a == bildirim atar(sistem zili).

//4) \" == normalde printf içinde " kullanıldığı için kodu bozar
//bu işaret (") işaretini yazdırır.
 

//=================================================================================================

//eşitlik ataması: if(a==b)

//eşit değillik ataması: if(a!=b)

//büyüklük küçüklük ataması: if(a<b) if(a>b)

//büyükeşit küçükeşit: if(a>=b) if(a<=b)


//==================================================================================================

//Atamalar:

//a+=1;    a+1 anlamına gelir. 

//a*=1;    a*1 anlamına gelir.

//a/=1;    a/1 anlamına gelir.

//a%=1;    a%1 anlamına gelir.

//1)++a      a+1 yapar ve bunu içinde bulunduğu işlemden önce kaydeder.

//2)a++      a+1 yapar ve bunu içinde bulunduğu işlemden sonra kaydeder.


//=================================================================================================


//Mantık operatörleri:

//if(a && b)    a ve b koşullarının ikisi de doğruysa çalışır.

//if(a || b)    a veya b koşullarından birinin doğru olması veya her ikisinin doğru olması çalışır.
                          
//if(! (a==b))  a=b ise çalışmaz a!=b ise çalışır.              


//=================================================================================================


//[printf,scanf,if,else,sqrt(x)(sayının kökünü alma) kullanımı için bir örnek:] 
/*
int main(){
	

   int a,b=0,c;
   
	printf("Enter number:");
	scanf("%d",&a);
	
	c=sqrt(a);
	b=c*c;
	
	if(b==a)
	{
		printf("this is square number.");
	}
	
	else
	{
	   printf("this is not square number.");
	}

}*/









//[while,pow(x,y)(üslü sayılar) kullanımı için bir örnek:]

/*
int main(){
	
    int x=2;
    int y;
    
    
    printf("Exit:-2 continue:2 Answer:");
    scanf("%d", &y);
    
    
    while(y>-1){
	
	int outcome1;
    int outcome2;
    
    int A,B,C=0;
    int order=0;
    
    int x=2;
    
    
	printf("\nEnter a order(max 3 and negative number is not included) number:");
	
	scanf("%d", &order);
	
	
	
	if(order==1){
		
		while(x>-1){
			
			
			printf("\nEnter a number:");
			scanf("%d",&A);
			
			if(A<10){
				printf("This number is amstrong.\n");
			}
			
			else{
				printf("This number is not single order.\n");
			
			}
		
		printf("\nExit:-2 continue:2 answer:");
		scanf("%d",&x);
		
	}
	
}

	else if(order==2){
		
		while(x>-1){
			
			
			printf("\nEnter a first number:");
			scanf("%d",&A);
			printf("\nEnter a second number:");
			scanf("%d",&B);
			
			outcome1=10*A+B;
			
			outcome2=pow(A,2)+pow(B,2);
			
			if(outcome1==outcome2){
				printf("This count is amstrong.\n");
			}
			else if(outcome1!=outcome2){
				printf("This count is not amstrong.\n");
			}
						
		printf("\nExit:-2 continue:2 answer:");
		scanf("%d",&x);
		
	}
}
	
	else if(order==3){
		
		while(x>-1){
			
			
			printf("\nEnter a first number:");
			scanf("%d",&A);
			printf("\nEnter a second number:");
			scanf("%d",&B);
			printf("\nEnter a third number:");
			scanf("%d",&C);
			
			outcome1=100*A+10*B+C;
			
			outcome2=pow(A,3)+pow(B,3)+pow(C,3);
			
			if(outcome1==outcome2){
				printf("This count is amstrong.\n");
			}
			else if(outcome1!=outcome2){
				printf("This count is not amstrong.\n");
			}
			
		printf("\nExit:-2 continue:2 answer:");
		scanf("%d",&x);
		
	}	
}
    printf("Exit program:-2 continue:2 Answer:");
    scanf("%d", &y);
	
}	
}
*/

//============================================================================================

//do/while while farkı do/while döngüsünde döngü yanlış olsa dahi 1 kere çalışır
//çünkü koşul sonda kontrol edilir.

//break; yapısı switch/case,for,while,do/while gibi döngü yapılarından direkt
//çıkışı sağlar.

//continue döngünün alt basamaklarını atlayıp döngünün en başından çalıştırılmasını
//sağlar.

//switch(koşul) case 1: case 2: şeklinde kullanılan bir operatör çeşitidir



//[switch,case,break,default kullanımı için bir örnek:](#include <windows.h> kütüphanesiyle
// sleep(beklenecek süre); kullanıcıyı bekletme işlevi gördü.) (default belirlenmemiş durum)
/*
int main()
{
	int selection,balance,change,deposit,draw,money;
	char name[100],password[100];
	
int x=4;

    printf("\a========Welcome========\n\n");
	sleep(2);
	
	printf("Please bank account name(Only):");
	scanf("%s", &name);
	
	printf("\nPlease bank account password:");
	scanf("%s", &password);
	
	printf("\n==Transaction successful==\n\n");
	
	while(x>-1){
	
	if(x==1){
		
		printf("\n\n\n====Goodbye take care of your self====\n\n\n");
		return 0;
	    }
	
	else if(x==4){
	
	printf("\n\n\n\nExit:-1\n\n1)Balance. \t\t\t\t 2)change name and password.\n\n3)Deposit. \t\t\t\t 4)Draw.");
	
	
		printf("\n\nWhat do you want for bank account:");
	scanf("%d", &selection);
	
	switch(selection){
	
		case 1:
			printf("\n\n\n=====Balance:%d=====\n\n\n", balance);
		    break;
		
		case 2:
	        printf("\n\n\n===Available name:%s===\n\n\n", name);
			printf("==========New name:");
			scanf("%s", &name);		
			printf("\n\n\n===Available password:%s===\n\n\n", password);
			printf("==========New password:");
	        scanf("%s", &password);
			printf("\n==Transaction successful==\n\n");
			break;
					
		case 3: 
		    printf("\n\n====How much deposit money:");
		    scanf("%d", &money);
		    balance+=money;
		    printf("\n\n======New balance:%d======\n\n\n",balance);
		    break;
		        
		case 4: 
		    printf("\n\n====How much draw money:");        
		    scanf("%d", &money);
		        
		    if(money>balance){
		        printf("\n\n\n==Transaction failed==\n\n");
			}
		    else if(balance>money){
		        balance-=money;
		        printf("\n\n======New balance:%d======\n\n\n",balance);
			}
		    break;
		        
		case -1:
			printf("\n\n\n====Are you sure for exit?====\n\n\n");
			printf("\n=====Please enter 1:");
			scanf("%d", &x);
		    break;
		        
				
				     
		    default:
		        printf("\n\n\n======Wrong Transaction======\n\n\n");
		    break;
		   
	        }
	    }
	}
}
*/	


//exp(x) e üslü x alır.
//log10(x) xin 10 tabanına göre logaritma alır.
//fabs(x) x mutlak değere alır.
//ceil(x) xin kendinden sonraki ilk tam sayı değerine yuvarlar.
//floor(x) xin kendinden önceki ilk tam sayı değerine yuvarlar.
//pow(x,y) x üslü y alır.
//fmod(x,y) x/y işlemiinin kalanını bulur.
//sin(x) xin sinüsünü hesaplar.*trigonometrik fonksiyonların tamamı için geçerli*

//==================================================================================
//long double==%Lf------------------//Büyük virgüllü sonuçlar için.

//long int==%ld--------------------//Büyük sonuçlar için.

//unsigned long int==%lu -----------//Büyük sonuçlu pozitif sayılar için.

//unsigned int==%u-----------------//pozitif sayılar için.

//int==%d--------------------------//Tam sayılar için.
 
//double==%f(printf)==%lf(scanf)----//Virgülden sonra 8 basamak gösterir.

//float==%f-------------------------//Virgülden sonra 4 basamak gösterir.
 
//short==%hd-----------------------//Taşınabilirlik için küçük verilere küçük boyut tanımlar.

//char==%c-------------------------//Harfler için ancak sayıları da tutabilir.

//===========================================================================================

//[Rand ve Srand kullanımı için örnek];

/*
int main(){
	
	for(int i=1; i<=20; i++){   //i sayısının 20 eşitliğinde olması zarın 20 kez atılmasını
	                            // temsil eder.
		
		printf("%10d", 1+(rand()%7)); //y+rand()%x şeklinde ki yazım da x değeri rastgele
		                              //üretilmiş sayıların üst sınırını belirler.
		                              //y üretilecek sayıların başlangıcıdır +1 ise 1 den başlanır
									  //+40 ise 40dan başlanır. şu şekilde düşünülebilir:
									  // y <=rand()<= x
		if(i%5==0){
			 
	    printf("\n"); // bu küçük oyun i değeri 5 e bölündüğün de kalan 0 olursa 
	                  // alt satıra geçmeyi sağlar böylece her satıra 5 değer girilmiş olur.   
		}
	}
}
*/



/*
int main(){
	
	srand(time(NULL));   //yukardaki sıralamadan tek fark budur
	                     //rastgele üretilen sayılar bazen aynı üretilir 
						 //bu hatayı önlemek için kullanılır. 
	
	for(int i=1; i<=20; i++){
		
		
		
		printf("%10d", 1+rand()&100);
		
		if(i%5==0){
			
			puts("\n");
		}
	}
}
*/


//============================================================================================

//Depolama sınıfı belirteçleri:

                //(otomatik depolama süreci)//auto değişkeni fonksiyon çağrıldığında
                                            //çoktan silinmiş olur çünkü kullanım esnasında
                                            //bellekte kaydedilir bloktan çıktığı anda silinir.
                                            
                                            
                /*
                void plus();
                
                int main(){
                	
                	plus();
                	plus();
                	plus();
                	plus();
                	plus();
                	
				}
                void plus(){
                	
                    auto int i=0;
                	printf("%d--", i);
                	i++;
				}
                */
                
//============================================================================================
                //(otomatik depolama süreci)//register değişkeni cpu da depolandığı için 
                                          //diğer değişkenlerden hızlı ulaşılır programlara
                                          //hız kazandırır.Ancak depolama alanı düşüktür
                                          //bu yüzden sık kullanılan değişkenler için 
                                          //uygundur.
                
                
                /*
                int main(){
                	register int i;
                	int numbers[6] = {11, 22, 33, 44, 55};
                	for(i=0; i< 5; i++){
                		printf("numbers[%d] value:%d\n", i,numbers[i]);
					}
				}
               */
               
//============================================================================================
                //(statik depolama süreci)//extern değişkeni int main{} fonksiyonun içinde 
                                          //değeri olmayan değişkenlerin fonksiyon içinde
                                          //kullanılabilir hale getirir.extern kullanılmaz ise
                                          //örnekteki x değeri gibi varsayılan 0 olarak
										  //görünür.
                                          

                /*
                int main(){
                    int x;	
				    extern int y;
				    printf("x:%d--y:%d", x, y);
				}
                    extern int y=20;
                    int x=10;
                */
 
 //===========================================================================================
                //(statik depolama süreci)//static değişkeni bloktan çıkılsa da değerini korur.
                                          //diğer hiç bir değişken bu özelliğe sahip
                                          //değildir.

                /*
                void plus();
                
                int main(){
                	
                	plus();
                	plus();
                	plus();
                	plus();
                	plus();
                	
				}
                void plus(){
                	
                    static int i=0;
                	printf("%d--", i);
                	i++;
				}
                */

//============================================================================================

//[For döngüsü:]

//for(int i=x; i <= a; ++i) şeklinde kullanılır değişken x kritiktir.
//a değeri döngünün kaç defa çalışacağını gösterir
//fonksiyonda i değeri tanımlanmak zorunda değildir çünkü for içinde tanımlanabilir while gibi
//değildir. ++i,--i,i+=5,i*=5 gibi farklı farklı şekillerde kullanılabilir
//bu açıdan while a göre algoritma da çok daha fazla seçenek sağlar.

//Örnek:

/*
int main(){                           
	                                     
	for(int i=2; i<=1000; i*=5){         
		
		printf("outcome:%d\n", i);
	}
	
}
*/

/*
int main(){                           
	                                     
	for(int i=2000; i>=500; i-=100){         
		
		printf("outcome:%d\n", i);
	}
	
}
*/

/*
int main(){
	
	srand(time(NULL));
	
	for(int i=1; i<=30; ++i){
		
		printf("--%d--", rand()%30);
		
		if(i%5==0){
			puts("\n");
		}
	}	
}
*/

//==================================================================================================
                
                

//DİZİLER(ÇOK ÖNEMLİ);



//a=5 b=6                             c[0]=1         (!!!) bir c[a]=b dizesinin a değeri daima 0 dan
//C[a+b]+=2;                          c[1]=2               başlar.b değeri değişkendir.
//C[11]=d ise                         c[2]=3
//C[11]=d+2 yeni sonuçtur (!!!)       c[3]=4       



//diziler de printf kullanımı: c[0]=12   c[1]=32  c[2]=48 ise  printf("%d", c[0]+c[1]+c[2]);
//                             şeklinde yazdırılır.   Çıktı:92



//diziler de değişken atama: c[6]=12 ise  x=c[6]/2; işlemi x değerine 6 sonucunu atar.


//diziler hafıza da şu şekilde yer alır:  int c[100],x[50]; bu işlemle bir c ve bir x dizesi 
//                                          atanmış olup bu dizelerin biri 100 diğeri 50 elemanlıdır.


//dizeler matematik kümeler gibi düşünülebilir.


//ÖRNEKLER:

/*
int main(){                                  //görünüşte çok kolay bir fonksiyondur ancak
	                                         //dizilerin çalışma prensibini öğrenmek amacıyla
	int n[9];                                //x ve y kullanımı, neden y+1 tercih edildiği
	                                         //çok dikkat edilmesi gereken konulardır
	for(int x=0; x<=9; x++){                 //diziler fonksiyonlarla birleştiğinde
		                                     //çok karmaşıklaşır öğrenme zorluğu çekmemek için
		n[x]=(5+x)*x;                        //bu nokta da biraz çalışılması gereklidir.(!!!)
		
	}                                         
	                                
	for(int y=0; y<=9; y++){
			printf("Index:%d       Denklem sonucu:%d\n", y+1,n[y]);
		}
	
}
*/




/*   
int main(){                                     //burada dikkat edilmesi gereken husus
	int n[6]={32, 27, 64, 18, 95, 14};          //dizi tanımlarken n[6] girip 6 eleman belirttik
		                                        //ancak for döngüsünde 5 tur döndürdük
	for(int x=0; x<=5; x++){                    //çünkü atama yapılırken eleman sayısı,
	                                            //çıktı alınırken index sayısı (0,1,2,3,4,5 şeklinde)
	printf("%4d", n[x]);                        //değerlerle davet edilir.
  } 
}
*/


//Kütüphane verisi kullanılarak boyut bildirilebilir,SIZE(isim değişkendir),10 değeri değişkendir.
/*
#define SIZE 10
int main(){
	
	int s[SIZE];
	
	for(int j=0; j<=SIZE-1; j++){
		s[j]=2+2*j;
	}
	
	for(int j=0; j<=SIZE-1; j++){
		
		printf("%7d%13d\n", j, s[j]);
	}
}
*/


//KRİTİK BİR ÖRNEK:(frequency=sıklık, array=dizi, size=boyut)
/*
#define ARRAY_SIZE 20
#define FREQUENCY_SIZE 6

int main(){
	
	int array[ARRAY_SIZE] = {1,1,2,5,4,3,2,1,5,3,4,2,1,5,5,3,2,1,3,2};//bir dizi oluşturuldu 
	                                                        //ve elemanları elle yerleştirildi.
	
	int frequency[FREQUENCY_SIZE]={0};  //bir dizi oluşturuldu ve elemanları serbest bırakıldı.
	
	
	for(int answer=0; answer < ARRAY_SIZE; answer++){  //Burada kritik öneme sahip  
		                                                  //bir numara var. 
		++frequency[array[answer]];                       
 	}
	//for döngüsünde answer değeri 0 a eşit:  //++frequency[array[0]];
	
	//array dizisinde  0.index == 1 değeri:  //frequency[1]=0;  //++frequency[1]=0+1; oldu
	
	//for döngüsünde answer değeri 1 e eşit: //++frequency[array[1]];
	
	//array dizisinde 1.index == 1 değeri:  //frequency[1]=1 olmuştu. //++frequency[1]=1+1; oldu.
	
	//bu küçük numara bir dizide hangi elemandan kaçar tane olduğunu bize gösterir.
	
	printf("%s%12s\n", "Rating", "Frequency");
	
	for(int rating=1; rating < FREQUENCY_SIZE; rating++){  //klasik dizi yazdırma.
		
		printf("%6d%12d\n", rating, frequency[rating]);
	}
}
*/


/*
#define ArraySize 101

int main(){
	
	int ratingA,ratingB,ratingC;
	int array[ArraySize];
	
	srand(time(NULL));
	
for(int i=1; i<ArraySize; ++i){
	
	array[i]=5+rand()%100;
	
	
	
	if(array[i]>=85){
		
		
	++ratingA;
	printf("\n\n%d numarali ogrenci, Tebrikler Diploma Notunuz:AA(%d)", i, array[i]);
	}
	
	else if(array[i]>=50 && array[i]<85){
		
		
	++ratingB;
	printf("\n\n%d numarali ogrenci, Tebrikler Diploma Notunuz:BB(%d)", i, array[i]);
	}
	
	else if(array[i]<50){
		
	++ratingC;
	printf("\n\n%d numarali ogrenci, Diploma Notunuz:CC(%d)\nSinif tekrarina kaldiniz.", i, array[i]);
	}
}
    
    printf("\n\nAA ogrenci:%d\nBB ogrenci:%d\nCC ogrenci:%d\n\n", ratingA, ratingB, ratingC);

}
*/



/*
#define SIZE 9

int main(){
	
	int n[SIZE]={3,6,4,3,2,6,7,2,3};
	
	
	printf("%s %12s %18s", "NO", "VALUE", "DIAGRAM");
	
	
	for(int x=0; x<=SIZE-1; ++x){
		
		printf("\n%d%12d%17s", x+1,n[x], "*");
		
		for(int y=2; y<=n[x]; y++){
			
			printf("%s", "*");
			
		}
		
		puts("\n====================================");
  }		
}
*/



//BİLGİ:
//string ve dizi aynı şeylerdir ancak string kelime ve harfler için kullanılır.
//örnek kullanım: char string1[]="birinci";
//string1 dizesine birinci kelimesindeki harfler atanır bu kullanımla.
//string ve diziler de null karakteri bulunur yani 0 karakter sabiti \0 olarak gösterilir.
//aslında 7 harften oluşan birinci kelimesi stringde bu sebepten dolayı 8 karakter olarak tutulur.
//null karakteri sonda bulunur.stringler de tum karakterler bu null karakteriyle sonlanır.
//yani boyut bildirirken null karakteri unutulmamalıdır.


//char string1[]={'b','i','r','i','n','c','i'); ataması ile char string1[]="birinci"; aynıdır.
//ayrıca char string1[0]={b} her ikisi içinde b değerini verecektir
//yani bu aslında bir dizedir sadece 0 1 2 3... index sayılarına harf yerleştirilir



//scanf("%s", string1); ifadesi klavyeden alınacak ister harf ister kelime olsun, 
//string1 dizesine yerleştirir.
//printf("%s", string1); ifadesi de klavyeden alınan veriyi olduğu gibi yazdırır.

//deneme yapabilirsiniz:

/*
#define SIZE 100
int main(){
	
	char string1[SIZE];
	
	for(int i=0; i<3; ++i){
		scanf("%s", string1);
		printf("%s\n", string1);
	}
}
*/

//ÖRNEK:
/*
int main(){
	
	char string1[100], string2[] = "string literal";
	
	printf("Enter a string:");
	scanf("%s", string1);
	printf("\nstring1:%s\n\n\nWords between in space:", string1);
	
	for(int i=0; string1[i] != '\0'; ++i){
		
		printf("%c ", string1[i]);
	}
}
*/





//depolama sınıfı belirteçleri,diziler,fonksiyonlar örneği:
/*
void staticArray();
void autoArray();

int main(){

//ilk çağrılış.
printf("functions first call:\n");
staticArray();
autoArray();
//çağrılış sonucunda statik dizi sonucu:5 otomatik dizi sonucu:6 bulundu. 

//ikinci çağrılış
printf("\nfunctions second call:\n");
staticArray();
autoArray();
//çağrılış sonucunda statik dizi sonucu kalıcı olarak bellekte korunduğu için sonuç	10 oldu.
//ancak otomatik dizi bloktan çıkıldığı anda silindiği için ilk çağrılış yine tekrarlanmış
//ve sonuç yine 6 bulunmuş oldu.
}

//statik dizinin fonksiyonu (bir sonraki konumuz fonksiyonlar)
void staticArray(){
	
	static int array[3];
	
	printf("\nStaticArray in value:\n");
	
	for(int i=1; i<=3; i++)
		printf("array[%d]=%d ", i, array[i]);
		
		printf("\nstaticArray out value:\n");
    
		for(int i=1; i<=3; i++)
			printf("array[%d]=%d ", i, array[i]+=5);
		
    
}

//otomatik dizinin fonksiyonu (bir sonraki konumuz fonksiyonlar)
void autoArray(){
	
	int array[3]={1, 2, 3};
	
	printf("\n\nautoArray in value:\n");
	
	for(int i=0; i<=2;i++)
		
		printf("array[%d]=%d ", i+1, array[i]);
		
		printf("\nautoArray out value:\n");
    
		
		for(int i=0; i<=2; i++)
			
			printf("array[%d]=%d ", i+1, array[i]+=5);
		
		puts("\n\n");
    }
//Örnekten edinilmesi gereken bilgi: otomatik depolama sınıfı fonksiyon ve dizelerde kullanılırsa
//bellekte bilgi kalıcı tutulmadığı için bazı algoritmalarda sorun çıkartır.

//statik depolama sınıfı kullanılması veriyi depoda kalıcı tutacağı için 
//algoritmanın hedefine göre doğru depolama sınıfı tercih edilmelidir. 
*/


//================================KRİTİK BİLGİLER========================================================

//DİZİLERİ FONKSİYONLARA GEÇİRMEK:

//int hourlyTemperature[24];      //bir dizi tanımladık.

//arraySettings[hourlyTemperature,24]   //bir fonksiyona önce dizinin ismini sonra boyutunu örnekteki gibi
//yerleştirdik.Tebrikler bir fonksiyona bir dizi başarıyla atandı bu fonksiyonun ismi arraySettings[x,y].  
//======================================================================================================

//C dilinde referansa göre çağrılma işlemi vardır.Bu şu şekilde gerçekleşir:

//%p dönüşüm belirteçlerinin yazdırılmasını sağlar, adresleri yazdırmak için kullanılır
//%p genellikle adresleri 16lık sistemde yazdırır.0dan 9a kadar rakamları ve Adan Fye kadar harfleri içerir.
//printf("%p-%p-%p", array, &array[0],&array); şeklinde kullanılır 3 kullanımda aynı sonucu verir.
//bu kullanımın sonucunda dizinin elemanlarının adresleri görünür %p bu işe yarar.
//adrese göre çağırma işlemi değere göre çağırma işleminden daha iyidir çünkü hızdan ve depolamadan
//kazanç sağlar.Yinede dizinin bağımsız elemanları değere göre çağrılır.
//İleri konularda adrese göre çağırma işlemi kasıtlı olarak yapılacak bunların hepsi ön bilgiydi. 

//ÖRNEK:

/*
int main(){
	
	char array[10]={"abc"};
	
	printf("  array=%p\n  &array[2]=%p\n  &array=%p\n\n", array, &array[2], &array);
	printf("  array=%s\n  &array[2]=%s\n  &array=%s\n", array, &array[2], &array);
}
*/

//========================================================================================================

//DİZİLERİ FONKSİYONLARA GEÇİRMEK:

//void arraySettings(int array[],int SIZE)   //bu kullanım array[] dizisinin bir tam sayı olduğunu tanımlar.  
                                             //int SIZE parametresi ise dizinin elemanlarının sayısını 
                                             //almayı beklemesi belirtilir.
/*
#define SIZE 5
void modifyArray(int b[], int size);   //2. yol atama.
                                       //bu fonksiyona herhangi bir dizi geçirilebilir.Hazır bekliyor.
									     
void modifyElement(int e);  //1.yol atama.
                            //Dizenin tek bir elemanı geçirilebildi.e harfi diziyi belirtiyor.

//Yani fonksiyonların tanım kısmındaki atamalar bağımsızdır. 
//Ana kod içerisinde farklı diziler aynı fonksiyon için kullanılabilir.

//Bu durumda ana kod içerisinde fonksiyon çağrılırken tanım kısmına yazılan 
//dizilerin isimleri ve boyutları bağımsız atamaların yerine geçer.

int main(){
	
	int a[SIZE] = {0,1,2,3,4};
	
	puts("Effects of passins entire array by reference:\n\n"//Tüm dizi adrese göre çağrıldı.
	"The values of the original arrey are:");   //orjinal dizi.
	
	for(int i =0; i< SIZE; ++i){ //Klasik dizi yazdırıldı.
		printf("%3d", a[i]);  //dizinin orjinal hazır elemanları.
	}
	puts("\n");
	
	modifyArray(a, SIZE);//bu fonksiyona önce dizinin ismi sonra boyutu geçirildi. 
	                     //2.yol atama.
	                     
	puts("The values of the modified arrey are:"); //Burada dizinin değiştirildiği bildirildi.
	
	for(int i=0; i< SIZE; ++i){ //Değiştirilmiş dizi klasik yazdırılıyor.
		printf("%3d", a[i]);
	}
	
	printf("\n\n\nEffects of passins array element  " //dizinin tek bir elemanının fonksiyona atandığı  
	"by value:\n\nThe value of a[3] is %d\n", a[3]);  //bildirildi.bu eleman orjinal halde yazdırıldı.
	                                                   
	modifyElement(a[3]); //bu eleman fonksiyona 1.yol ile atanarak değiştirilmiş hali yazzdırıldı.
	
	printf("The value of a[3] is %d\n", a[3]); //bu elemanın tekrar orjinal hali yazdırıldı.
}

void modifyArray(int b[], int size){ //içeriye tanımlanan dizinin tüm elemanları for döngüsü sayesinde
                                     //sırayla 2 ile çarpıldı.
	for(int j = 0; j<size; ++j){     //2.yol atama.
		b[j]*=2;
	}
}


void modifyElement(int e){ //fonksiyona atanmış olan dizenin tek bir elemanı atanabildi.
	e*=2;                                        //1.yol atama. 
	printf("Value in modify Element is %d\n", e);//bu eleman 2 ile çarpıldı ve değiştirilmiş hali yazdırıldı.
}
*/
//a[SIZE] dizesinin modifyElement fonksiyonuna atanırken index sayısını değiştirerek mantığını 
//daha rahat kavrayabilirsiniz.(Unutmayın kodun başlangıcında a dizesi modifiye edildi artık yeni değerleri:
//index-değer= 0-0 , 1-2 , 2-4 , 3-6 , 4-8)


//===========================================BUBBLE-SORT===================================================

//Bu numara dizelerde ki index sayılarında saklı değerleri
//büyükten küçüğe veya küçükten büyüğe sıralamanızı sağlar.


 /*
#define SIZE 10

int main(){
	
	int a[SIZE] = {12,34,47,56,54,23,12,77,89,98};
	
	puts("Data items in original order"); //Dizinin elemanlarının sırasız hali yazdırılacağı bildirildi.
	
	for(int i=0; i<=SIZE; i++){
		
		printf("%4d",a[i]);        //klasik for döngüsü ile dizenin elemanları sırayla yazdırıldı.
	}
	
	for(int pass=0; pass<=SIZE; ++pass){  //10 eleman olduğu için bu döngü 10 kere tekrar edilmelidir ki
		                                  //matematiksel olarak tüm elemanlar 1 kere kontrol edilmiş olsun.
		for(int i=0; i<=SIZE-1; ++i){
			
			if(a[i]>a[i+1]){   //bir ara değer tanımlanarak index sayıların küçük olanın küçük indexe
			                   //büyük olanın büyük index e geçirilebilmesi için değiş-tokuş yapıldı
			int hold=a[i];     //Tüm bobble-sort hikayesi bundan ibaret.
			a[i]=a[i+1];
			a[i+1]=hold;
		  }
	    }		
      }
	
	puts("\nData items in ascending order"); //dizenin değiştirildiği bildirildi.
	
	for(int i=0; i<=SIZE; ++i){
		
		printf("%4d",a[i]); //klasik for döngüsü ile dizenin elemanları sırayla yazdırıldı.
	}
		
}
*/

//=========================================================================================================

//DİZİ,FONKSİYON KULLLANIM ÖRNEĞİ:

/*
#define SIZE 99

void mean(int answer[]);//answer[] önemsiz içerisi x[] dahi yazılabilir sadece fonksiyona bir dizi
void median(int answer[]);//atanacağı belirtiliyor.                                            
void mode(int frequency[],int answer[]);    
void bubbleSort(int array[]);//answer[] array[] kullanımı aynı. 
void printArray(int array[]);    
                                  //fonksiyon tanımlamalarının amacı fonksiyonların ana kodun          
                                  //altında kaldığı durumlar da bilgisayarın ana kod          
                                  //içerisinde kullanılmış fonksiyona tanımlanmamış 
                                  //fonksiyon uyarısı vermemesi içindir.
//ANA KOD
int main(){
	
	int frequency[10] = {0};
	int response[SIZE] = {0};
	srand(time(NULL));
	
	for(int i=0; i<=SIZE; ++i){
		
		
		response[i]=1+rand()%9;  //for döngüsü ile response dizesine 1-9 arası 99 rakam atanıyor.
	}

mean(response);//fonksiyonlara gerekli dizeler atanıyor.
median(response);         
mode(frequency, response);
}

//FONKSİYON 1

void mean(int answer[]){
	
	printf("%s\n%s\n%s\n", "--------", " Mean", "--------");
	
	int total=0;
	
	for(int j=0; j<SIZE; ++j){
		
		total+=answer[j];//answer dizisi aslında response dizisidir.
	}                    //burada rastgele üretilen 99 rakam toplanıyor.
	
	printf("The mean is the average value of the data\n"
	       "items.The mean is equal to the total of\n"
		   "all the data items divided by the number\n"
		   "of data items (%u).The mean value for\n"
		   "this run is: %u/%u = %4.f\n\n",
		   SIZE, total, SIZE, (double)total / SIZE);//elemanlar toplamı/eleman sayısı yapılarak
		                                            //aritmetik ortalama elde ediliyor.
}

//FONKSİYON 2

void median(int answer[]){
	
	printf("\n%s\n%s\n%s\n%s", "--------", "Median", "--------",
	"The unsorted array of responses is");//süsleme
	
	printArray(answer);//diziyi yazdırmak için fonksiyon yazılmış.answer dizisi aslında response dizisi.
	bubbleSort(answer);//99 eleman küçükten büyüğe sıralanmıştır.answer aslında response dizisi.
	
	printf("%s", "\n\nThe sorted array is");
	printArray(answer);//diziyi yazdırmak için fonksiyon yazılmış.answer dizisi aslında response dizisi.
	
	printf("\n\nThe median is element %u of\n"
	       "the sorted %u element array.\n"
		   "For this run the median is %u\n\n",
		   SIZE / 2, SIZE, answer[SIZE/2]);//answer[SIZE/2]=response[SIZE/2]bubble sort ile sıralandı.  
}                                          //ortanca değer 5 bulundu ve yazdırıldı.

//FONKSİYON 3

void mode(int frequency[],int answer[]){
	
	printf("\n%s\n%s\n%s\n", "--------", " Mode", "--------");//süsleme
	
	for(int rating=1; rating<=9; ++rating){ //frequency[1]=0 frequency[2]=0 ancak şimdilik 
		                                    //burada atama yapıldı.
		frequency[rating] = 0;
	}
	
	for(int j=0; j<SIZE; ++j){   //reponse[0]=1 frequency[1]=0 idi ancak son durumda frequency[1]=1 oldu.
		                         //reponse[1]=1 frequency[1]=1 idi ancak son durumda frequency[1]=2 oldu.
		++frequency[answer[j]];  //bu şekilde 99 işlem sonucunda 1-9 arası rakamlardan kaçar tane olduğu
	}                            //hesaplandı.07.05.2024 öğrencilik zamanımda en hoşuma giden mantıksal
	                             //kod.
	                             
	printf("%s%11s%19s\n\n",
	       "Response", "Frequency", "Bar Chart");//süsleme
		   
	int largest = 0;
	int modeValue = 0;
	
	for(int rating=1; rating <= 9; ++rating){
		
		printf("%8zu%11d        ", rating, frequency[rating]);//sırasıyla 1-9 rakamları yazdırılmış,
		                                                      //1-9 rakamlarından kaçar tane olduğu da
		                                                      //eklenmiş.
		                                                       
		if(frequency[rating] > largest){//99 eleman arasında en sık kullanılan elemanın bulunması                     
			largest = frequency[rating];//için oluşturulmuş algoritma.bu elemanın kaç defa bulunduğu da
			modeValue = rating;         //algoritma içerisinde mevcut.
		}
	
	//en küçük rating 1 largest değeri 0 her türlü ıf koşuluna girecek.girdikten sonrası için,rating 1 
	//largest artık 1 rakamından kaç adet bulunuyorsa bu değere eşittir.öyle bir an gelecek ki
	//rating 1-9 arası hiç bir rakam x rakamından daha fazla bulunmayacak bu şekilde largest
	//rating değerinden büyük olacağı için if koşuluna girmeyecek.largestin ve mode değerinin son değeri  
	//kaç ise bu değerler dizenin en çok kullanılan elemanı seçilecek(mod).
	
	
	for(int h=1; h<=frequency[rating]; ++h){
		
		printf("%s", "*");//bu algoritmanın mantığı ise atıyorum rating 1 değerin de 1 rakamından
	}                     //14 adet var 14 defa yan yana * atarak 1 değerini simgeleyecek 
	   puts("\n");        //bu işlem son rating değeri 9 da bitirildikten sonra h=10 değerine ulaşsa bile
   }                      //rating 9 değerinden büyük olacağı için for dışına çıkıp algoritmayı bitirecek.

printf("\nThe mode is the most frequent value.\n"
       "For this run the mode is %d which occured %d times.\n",
	   modeValue, largest);//dizinin modu ve kaç adet bulunduğu yazdırılıyor.
}

//FONKSİYON 4

void bubbleSort(int array[]){ //klasik bubbleSort sıralaması yukarda anlattım.
	
	for(int pass=0; pass<SIZE; ++pass){
		
		for(int i=0; i < SIZE-1; ++i){
			
			if(array[i] > array[i+1]){
				int hold = array[i];
				array[i] = array[i+1];
				array[i+1] = hold;
		  }
		 }
		}
}

//FONKSİYON 5

void printArray(int array[]){ //dizinin yazdırılması için fonksiyon oluşturulmuş.
	
	for(int j=0; j<SIZE; ++j){
		
		if(j%20 == 0){ //20-40-60-80 rakam yazdırıldıktan sonra kalan değeri 0 a eşit olacaktır.
 			puts("\n");//bu sayede 20 rakam da bir alt satıra geçmeye yarar.
		}
		
		printf("%2d", array[j]);//rakamlar arası 2 şer boşluk konularak dizeyi yazdırır.
	}
}
*/



/*
#define SIZE 100


int linerSearch(int array[], int key, int size);//fonksiyona bir dizi atandı.size dizinin boyutu kabul 
                                                //edildi.key kullanıcıdan alınacak veri kabul edildi.

int main(){
	
	int array[SIZE] = {0};//dizinin 100 indexi de 0 a eşitlendi.
	
	
	for(int i=0; i<SIZE; ++i){//dizinin tüm index değerleri index*2 olarak atandı.(0-2-4-6-8-10-12-14)
		
		array[i]=2 * i;
	}
	
	
	printf("Enter integer search key: ");//kullanıcıdan bir sayı değeri istendi.arama yapılması için.
	
	int searchKey = 0;//searchkey arama yapılmak için kullanılacak sayının atanacağı konumdur.
	
	scanf("%d", &searchKey);//kullanıcıdan sayının alındığı yer.
	
	int subscript = linearSearch(array, searchKey, SIZE);//fonksiyona gerekli veriler atandı.
//subscript=alt index.	                                 //konu ilerledikçe detaylı anlatmayı bıraktım.
	if(subscript != -1){
		
		printf("Found value at subscript %d\n", subscript);//fonksiyondan geri dönüş gerçekleştiğinde,
	}                                     //-1 ve index değeri dönüşü sağlanmış olacak.
	else{                                 //-1 olmayan tüm değerler geçerli koşulu sağlayacak ve
		                                  //kullanıcıya sunulan değerin indexi sunulmuş olacak.
		                                  
		puts("Value not found.");//koşulun -1 dönüşünde ise bu algoritma için bunlar tek sayılardır,
	}                            //kullanıcıya geçerli bir index bulunmadığı bilgisi verilecek.
	 
}


int linearSearch(int array[], int key, int size){//yukardaki koşula geri dönüş veren fonksiyon.
	                                     //for döngüsü ile tüm indexler if koşuluna sokuluyor,
	for(int i=0; i<size; ++i){           //key değerimiz aslında searhckeydir.searchkey kullanıcıdan
		                                 //alınmış sayıdır.
		                                 
		                                 
		if(array[i] == key){ //mantık şu şekildedir:  
			                 //array[0]=0   array[1]=2  array[2]=4  array[3]=6   array[4]=8 olarak atandı. 
			return i;        //bunu yukarda for döngüsü ile yapmıştık.
		}                  
                             //mantık:
							 		
	}                        //searchkey değeri 4 geldiğin de array[2] değeri koşulu sağlar, 
	                         //i yani 2 değeri fonksiyondan dışarı verilir,if koşuluna girer 
	return -1;               //ve kullanıcıya koşulu sağladığı için sunulur.
}                            //ancak searchkey değeri 7 geldiğinde 2*x sonucunun tam sayı değeri 
                             //array[i] dizesinde mevcut olmadığı için dışarı -1 verilir
                             //koşul sağlanmadığı için if değeri kullanıcıya not found bildirimi verir.

*/



/*
#define SIZE 15

int binarySearch(int binary[], int key, int low, int high);//atamalar yapıldı.
void printHeader();
void printRow(int binary[], int low, int mid, int high);

int main(){
	
	int array[SIZE] = {0};//dizi elemanları 0 a eşitlendi.
	
	for(int i=0; i<SIZE; ++i){//döngü yardımıyla tüm indexler sırası ile 2 ile çarpılarak 
		                      //yeni değerler atandı bu şekilde dizi de tek sayı kalmadı.
		array[i] = i*2;
	}
	
	printf("%s", "Enter a number betwenn 0 and 28: ");//kullanıcan 0-28 arası sayı istendi.
	int key = 0;
	
	scanf("%d", &key);//0-28 arası sayı kullanıcıdan alındı ve key konumuna atandı.
	
	printHeader();//fonksiyonu takip et alt satıra geçmeden önce geri bu satıra dön!
	
	int result = binarySearch(array, key, 0, SIZE-1);//fonksiyona gerekli atamalar yapıldı geri dönüt
	                                                 //if koşulunda değerlendirilebilmesi için result
	                                                 //konumuna atandı.fonksiyona atla sonra geri dön!
	                                                 //geri dönüşün çok komik olacak :D:D:D:D...
	
	if(result != -1){                                
		
		printf("\n%d found at subscript %d\n", key,result);
	}
	else{
	//demek geri dönmeyi başardın :( beklenmedik son...	
		printf("\n%d not found\n", key);
	}
}

int binarySearch(int binary[], int key, int low, int high){//binary==array dizisi,low=0,high=14 
	                                            //key kullanıcıdan alınan sayı değişkeni!
	                                            //0 14den küçük olduğunda (0+14)/2= 7 ile middle atandı.
												//yani while sonsuz döngüde.!!ilk çalışma!!
	                                            //Mevcut bu durum birazdan değişecek.                                        
	while(low<=high){                           //doğru sonuç için printRow fonksiyonuna her çalışmada
		                                        //atlayıp tekrar buraya dön.
		                                        
		                                       
		int middle = (low + high) / 2;//1)middle değeri 7.
		                              //2)middle değeri artık 3.
		                              //3)middle değeri artık 5.
		                              //4)middle değeri artık 4.
		                              //5)low=4 high=3 while return -1!!!
		                              
		printRow(binary, low, middle, high);//1)middle 7 high 14 ile çalıştı yazzdırdı!fonksiyona atla!
		                                    //2)middle 3 high 6 ile çalıştı yazdırdı!fonksiyona atla!
		                                    //3)middle 5 high 6 ile çalıştı yazdırdı!fonksiyona atla!
		                                    //4)middle 4 high 4 ile çalıştı yazdırdı!fonksiyona atla!
		                                    
		                                    
		if(key == binary[middle]){//1)key=7 döngüden çıkılamadı.Bütün savaşın başlangıcı!!!
			                 //2)7 3 ile eşit değil koşula girilmedi.
			                 //3)7 5 ile eşit değil koşula girilmedi.
			return middle;   //4)7 8 ile eşit değil koşula girilmedi.
		}
		
		
		else if(key<binary[middle]){//1)7 14 değerinden küçük! high değeri artık 6!
			                        //2)7 6dan küçük değil! koşula girilmedi bile.            
			high = middle-1;        //3)7 10dan küçük! high değeri artık 4! 
		}                           //4)7 8den küçük! high değeri artık 3!
		
		
		else{                       //2)low değeri artık 4 oldu.koşuldan çıkılmadı!
			
			low = middle+1;
		}
	}
	
	return -1;
}

void printHeader(){
	
	puts("\nSubscripts:");
	
	
	for(int i=0; i<SIZE; ++i){
		
		printf("%3d", i);//dizi de değeri mevcut olan indexler for döngüsü ile kullanıcıya sunuldu.
	}
	
	puts("\n");
	
	for(int i=0; i<=4*SIZE; ++i){
		
		printf("%s", "-");//for ile süsleme yapıldı.
	}
	
	puts("\n");
	
}

//burada yazılı anlatmam mümkün değildi ancak kolay bir nokta okuyucu
//bunu halledebilir.dikkat edilmesi gereken husus eşitliğe göre elemanlar yazdırılıyor.
//else aralıkta mevcut olan değerlerin yazdırılmamasına sebep oluyor.
//aralıkta mevcut olmayan değerlerin de yazdırılmasına sebep oluyor.
//if görüntü estetik olması için olmayan değerlerin yerine boşluk atıyor. 

void printRow(int binary[], int low, int mid, int high){
	
	for(int i=0; i<SIZE; ++i){
		
		if(i<low || i>high){//1)low 0 high 14 ile çalıştı!
			                //2)low 0 high 6 ile çalıştı!
			                //3)low 4 high 6 ile çalıştı!
			                //4)low 4 high 4 ile çalıştı!
			printf("%s", "     ");
		}
		
		
		else if(i==mid){//1)middle=mid 7 high 14 ile çalıştı!binary[7]=14 değerini 14* olarak yazdırdı.
			            //2)middle=mid 3 high 6 ile çalıştı!binary[3]=6 değerini 6* olarak yazdırdı.
			            //3)middle=mid 5 high 6 ile çalıştı!binary[5]=10 değerini 10* olarak yazdırdı. 
			            //4)middle=mid 4 high 4 ile çalıştı!binary[4]=8 değerini 8* olarak yazdırdı.
			printf("%3d*", binary[i]);
		}
		
		
		else{
			
			printf("%3d ", binary[i]);
			//1)low 0 high 14 ile çalıştı!aralıkta mevcut olmayan indexlerin değerleri yazdırıldı.
			//2)low 0 high 6 ile çalıştı!aralıkta mevcut olmayan indexlerin değerleri yazdırıldı.
		    //3)low 4 high 6 ile çalıştı!aralıkta mevcut olmayan 4,5,6 indexlerinin değerleri yazdırıldı.
		    //4)low 4 high 4 ile çalıştı!aralıkta mevcut olmayan tek index=4 değeri=8.
		
		}  	
    }
    puts("\n"); 
}
//başarının anahtarı pes etmemektir!!!08.05.2024.
*/

//=========================================================================================================

//ÇOK BOYUTLU DİZİLER:


//int array[satır][sütun];

//int array[3][4];

//      1      2         3        4             //Tablo içindeki değerler index sayıları temsil ediyor
//  1 a[0][0]  a[0][1]   a[0][2]  a[0][3]       bir fonksiyonda atama yapılırken a[3][4] 3 elemanın
//  2 a[1][0]  a[1][1]   a[1][2]  a[1][3]       4 alt elemanı bulunduğu bildirilir yani bunlar index
//  3 a[2][0]  a[2][1]   a[2][2]  a[2][3]       sayılar değil eleman sayılarıdır soldaki tablo 
                                                //atama mantığının anlaşılması için index sayılarla yazıldı

//1. eleman 0. index 4 alt elemanı var 0-3 indexlerine atanmış.
//2. eleman 1. index 4 alt elemanı var 0-3 indexlerine atanmış.
//3. eleman 2. index 4 alt elemanı var 0-3 indexlerine atanmış.

//indexler neden önemli? 
//yazdırma yapılırken bu index sayılarına ihtiyacımız var doğru yerleştirmeyi yapabilmek için.

//çok boyutlu dize nasıl atanır?
//bunun 3 farklı yolu var:

//int a[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

/*
void printArray(int a[][3]);
int main(){
	
	int a[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	
	printf("Array:\n");	
	printArray(a);
}
void printArray(int a[][3]){
	
	for(int i=0; i<=2; ++i){
		
		for(int j=0; j<=2; ++j){
			
			printf(" %d ", a[i][j]);
		}
		puts("\n");
	}
}
*/

/*
void printArray(int a[][3]);
int main(){
	
	int a[][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	
	printf("Array:\n");	
	printArray(a);
}
void printArray(int a[][3]){
	
	for(int i=0; i<=2; ++i){
		
		for(int j=0; j<=2; ++j){
			
			printf(" %d ", a[i][j]);
		}
		puts("\n");
	}
}
*/

/*
void printArray(int a[][3]);
int main(){
	
	int a[][3] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	printf("Array:\n");	
	printArray(a);
}
void printArray(int a[][3]){
	
	for(int i=0; i<=2; ++i){
		
		for(int j=0; j<=2; ++j){
			
			printf(" %d ", a[i][j]);
		}
		puts("\n");
	}
}
*/

//Açıkcası ne işe yaradığını anlamadım aynı şeyi tek bir dizi ve forla yapabilirdim vardır bir
//düzenek vardır bir düzenek ;)



/*
#define STUDENTS 3
#define EXAMS 4
//pupils=öğrenci  grades=notlar tests=sınavlar row=sıra column=sütun

int minimum(int grades[][EXAMS], int pupils, int tests);//Klasik fonksiyon atama.
int maximum(int grades[][EXAMS], int pupils, int tests);
double average(int setOfGrades[], int tests);
void printArray(int grades[][EXAMS], int pupils, int tests);


int main(){
	
	int studentGrades[STUDENTS][EXAMS] = {0};
	srand(time(NULL));//Diziye rastgele 1 ile 100 arasında sayılar atandı.
	
	for(int x=0; x<=2; ++x){
		
		for(int y=0; y<=3; ++y){
		
		studentGrades[x][y]=1+rand()%100;
	   }
	}
	
	
	
	puts("The array is:");
	printArray(studentGrades, STUDENTS, EXAMS);//Yazdırma dizisi çağrıldı.
	                    //Bir iki boyutlu dizi ,elemanı ve alt elemanı atandı. 
	
	
	
	printf("\n\nLowest grade:%d\nHighest grade:%d\n",  //fonksiyon printf içerisinde çağrılmış.
	        minimum(studentGrades, STUDENTS, EXAMS),   //önce minimum sonra maximum fonklarına atlayalım.
			maximum(studentGrades, STUDENTS, EXAMS));
			
	for(int student=0; student<STUDENTS; ++student){
		
		printf("The average grade for student %d is %.2f\n",    //Satırlarda ki 4 sınavın ayrı ayrı
		student, average(studentGrades[student], EXAMS));      //not ortalamaları hesaplanmış.
	}					                                      //average fonkuna atlayalım.
}



                                     //3         //4
int minimum(int grades[][EXAMS], int pupils, int tests){
	
	int lowGrade = 100;
	
	for(int row=0; row<pupils; ++row){
		
		for(int column=0; column<tests; ++column){ //Çok hoş bir numara...
			                                      //for döngüsü ile ilk çalışmada mevcut bütün notlar
			if(grades[row][column]<lowGrade){    //100den küçük olduğu için ilk çalıştırma ne olursa
				                                //olsun koşulu sağlar.Artık lowgrade [0][0] olarak atanır
				lowGrade=grades[row][column];  //ancak bundan sonraki her çalıştırmada mevcut not
			}                                 //sıradaki notla karşılaştırılır en küçük nota
		}                                    //sıra geldiğinde işlem sonlanır.
	}
	return lowGrade;
}





int maximum(int grades[][EXAMS], int pupils, int tests){ //maximum fonksiyonu minimum fonksiyonunun
	                                                    //aynısıdır.
	int highGrade = 0;
	
	for(int row=0; row<pupils; ++row){
		
		for(int column=0; column<tests; ++column){
			
			if(grades[row][column]>highGrade){
				
				highGrade=grades[row][column];
			}
		}
	}
	
	return highGrade;
}




            //studentGrades[]         //4
double average(int setOfGrades[], int tests){
                   
    int total=0;

    for(int test=0; test<tests; ++test){//İki boyutlu dizi tek boyutlu diziye atanmış.çünkü satır satır
	                                   //Hesaplama yapıyoruz.
	                                   
	total+=setOfGrades[test];//Tek satırdaki bütün elemanlar toplanmış.
    }      //studentGrades[EXAMS] = {A, B, C, D}  *temsili*
	
	return(double) total/tests;//Toplam/4 = ortalama.	
}



                            //4        //3          //4
void printArray(int grades[][EXAMS], int pupils, int tests){
	
	printf("%s", "                [0]  [1]  [2]  [3]");//Süsleme
	
	for(int row=0; row<pupils; ++row){//for 3 kere dönecek ve sıraları alt alta yazdıracak.
		
		printf("\nstudentGrades[%d] ", row);
		
		
		for(int column=0; column<tests; ++column){//for 4 defa dönecek ve notları yazdıracak 
			                                      //küçük numara row değerinin 0,1,2,3 
			                                      //column değerinin 0,1,2,3,4 indexlerini
			                                      //for ile alarak notları doğru yazdırmasıdır.
			printf("%-5d", grades[row][column]);
		}
	}
}
*/


/*
void print1DArray(int size, int array[size]);
void print2DArray(int row, int col, int array[row][col]);//bu tanımlama ile fonksiyona atama yapılırken
                                                        //dizi atamasını son sıraya koyduk fonksiyonu kod 
                                                       //içinde çağırıken de bu sıraya dikkat etmeliyiz.
int main(){
	
	srand(time(NULL));
	
	printf("%s", "Enter size of a one-dimensional array: ");
	int arraySize = 0;
	scanf("%d", &arraySize);//kullanıcıdan veri alıp atadık. 
	
	int array[arraySize];//bu veri 1 boyutlu diziye atandı.
	
	
	printf("%s", "Enter number of row in a 2D1 array:");//kullanıcıdan 2D dizi için sırayla
	int row1 = 0;                                                  //row1,col1 değerleri alındı.
	int col1 = 0;
	scanf("%d", &row1);
	printf("%s", "Enter number of colums in a 2D1 array:");
	scanf("%d", &col1);
	
	int array2D1[row1][col1];//alınan veriler array2D1 dizisine atandı.
	
	
	printf("%s", "Enter number of row in a 2D2 array:");//kullanıcıdan 2D dizi için sırayla
	int row2=0;                                                    //row2,col2 değerleri alındı.
	int col2=0;
	scanf("%d", &row2);
	printf("%s", "Enter number of column in a 2D2 array:");
	scanf("%d", &col2);
	
	int array2D2[row1][col1];//alınan veriler array2D2 dizisine atandı.
	
	
	printf("\nSize of(array) yields array size of %d byts\n", sizeof(array));
	
	for(int i = 0; i<arraySize; ++i){
		
		array[i]=(i+5)*2;//indexlere atama yapıldı.1D array için.
	}
	
	for(int i=0; i<row1; ++i){
		
		for(int j=0; j<col1; ++j){
			
			array2D1[i][j]=1+rand()%25;//2D1 dizisi için sütun sayısına bağlı olarak indexlerine atama yapıldı.
		}
	}
	
	for(int i=0; i<row2; ++i){
		
		for(int j=0; j<col2; ++j){
			
			array2D2[i][j]=1+rand()%25;//2D2 dizisi için sütun sayısına bağlı olarak indexlerine atama yapıldı.
		}
	}
	
	puts("\n One-dimensional array:");//1D arrayin ekrana verileceği bildirildi.
	print1DArray(arraySize, array);
	
	puts("\nFirst two-dimensional array 1:");//2D1 arrayin ekrana verileceği bildirildi.
	print2DArray(row1, col1, array2D1);
	
	puts("\nSecond two-dimensional array 2:");//2D2 arrayin ekrana verileceği bildirildi.
	print2DArray(row2, col2, array2D2);
}


void print1DArray(int size, int array[size]){
	
	for(int i=0; i<size; ++i){
		
		printf("array[%d]=%d\n", i, array[i]);//1D dizi for döngüsü ile kullanıcı girdisi değişkenine
	}                                        //göre ekrana bastıran fonksiyon.
}


void print2DArray(int row, int col, int array[row][col]){
	
	for(int i=0; i<row; ++i){
	
	for(int j=0; j<col; ++j){
		
		printf("%5d", array[i][j]);//2D dizi for döngüsü ile kullanıcı girdisi değişkenine
	}                             //göre ekrana bastıran fonksiyon.
	 
	puts("\n");
  }
}
*/



/*
#define SIZE 10
int whatIsThis(int b[], int p);

int main(){
	
	int a[SIZE] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	int x=whatIsThis(a, SIZE);
	
	printf("Result is %d\n", x);
}

int whatIsThis(int b[], int p){
	
	if(1==p){
		
		return b[0];
	}
	else{
		
		return b[p-1]+whatIsThis(b, p-1);
	}
}
*/
//ilginç bir algoritma...for döngüsü kullanmadan algoritmik olarak if ile dizinin elemanları toplanmış.



//===================================POİNTERS==============================================================                

//ÖRNEK:

 /*
  int main(void) {
  int a = 7;
    int *aPtr = &a; 
//bu kullanım *yPtr=&y;                       
//y değişkenini yPtr gösterici değişkenine atar
 
    printf("Address of a is %p\nValue of aPtr is %p\n\n", &a, aPtr);
    //printf("%p", yPtr); y değişkeninin adresini yazdırır.
    //adresi yazdırmak için %p kullanılır.                 
    
    printf("Value of a is %d\nValue of *aPtr is %d\n\n", a, *aPtr);
    //printf("%d", *yPtr); y değişkeninin değerini yazdırır,göstericinin nesnesine
    //erişmek.
    
    printf("Showing that * and & are complements of each other\n");
    printf("&*aPtr = %p\n*&aPtr = %p\n", &*aPtr, *&aPtr);
    //(*) ve (&) birbirinin eşleniğidir.
 }
*/

/*
int cubeByValue(int n);

int main(){
	//değere göre çağırma örneği.
	int number = 5;
	
	printf("The original value of number is %d", number);
	number = cubeByValue(number);
	printf("\nThe new value of number is %d\n", number);
}

int cubeByValue(int n){
	return n*n*n;
}
*/

/*
void cubeByReference(int *nPtr);

int main(){
	//referansa göre çağırma örneği.
	int number = 5;
	
	printf("The original value of number is %d", number);
	cubeByReference(&number);
	printf("\nThe new value of number is %d\n", number);
}

void cubeByReference(int *nPtr){
	*nPtr=*nPtr * *nPtr * *nPtr;
}
*/

/*
void convertToUppercase(char *sPtr);

int main(){
	char string[] = "cHaRaCters and $32.98";
	
	printf("The string before conversion is:%s\n", string);
	convertToUppercase(string);
	printf("The string after conversion is:%s\n", string);
}

void convertToUppercase(char *sPtr){
	
	while(*sPtr != NULL){ //tüm char dizilerinin son elemanı 0 NULL ile biter yani while a son elemana 
		                 //geldiğinde dur dedik.
		                 
		*sPtr = toupper(*sPtr);//toupper(x) parantez içerisindeki değişkenleri büyük harf yapan fonk.
		               //hazır kütüphane hünerleri...
		               
		++sPtr;//diğer karaktere geçer.     
	}
}
*/

/*
void printCharacters(const char *sPtr); //const ataması değerin değiştirilemez olduğunu gösterir.

int main(){
	
	char string[] = "Print characters of a string";
	
	puts("The string is:");
	printCharacters(string);
	puts("\n");
}

void printCharacters(const char *sPtr){
	
	for(; *sPtr != '\0'; ++sPtr){
		
		printf("%c", *sPtr);
	}
}
*/

//burada bir derleme hatası gösterilmektedir sabit olarak atanan değişken sabit
// olmayan gösterici ile değiştirilmeye çalışılmış.
//ancak değiştirilememiştir.

//başka bir örnke:

/*
void f(const int *xPtr);

int main(){
	
	int y=7;
	
	f(&y);
}

void f(const int *xPtr){
	
	*xPtr = 100;
}
*/
//farklı olarak bu kod hata verecektir.


/*
int main(){
	
	int x=5,y;
	
	const int*const ptr=&x;
	
	printf("%d\n", *ptr);
	
	*ptr=7;
	ptr=&y;
}
*/
//sabit bir veriyi sabit bir göstericiyle değiştirmeye çalışmak.



//==================BUBBLE-SORT USING PASS-BY-REFERENCE====================================================

/*
#define SIZE 10
void bubbleSort(int *array, int size);//*array belirteç dizi olarak atandı.

int main(){
	
	int a[SIZE] = {2, 6, 4, 8, 10, 12, 89, 68, 45, 37};
	
	puts("Data items in original order");
	
	for(int i=0; i<SIZE; ++i){
		
		printf("%4d", a[i]);
	}
	
	bubbleSort(a, SIZE);//klasik bubblesort a atla!
	
	puts("\nData items in ascending order");
	
	for(int i=0; i<SIZE; ++i){
		
		printf("%4d", a[i]);
	}
	
	puts("\n");
}

void bubbleSort(int *array, int size){
	
	void swap(int *elemnt1Ptr, int *element2Ptr);//swap fonksiyonuna atla!
	
	
	for(int pass=0; pass<size-1; ++pass){//klasik bubble algoritması.
		
		for(int j=0; j<size-1; ++j){
			
			if(array[j]>array[j+1]){//küçükten-büyüğe tam tersi bir sıralama için (j) (j+1) değerlerinin
				                   //yerlerini değiştir.
				 
				 
				 
				 //BU ÖNEMLİ BİR KULLANIM!!!
				 
				 //C'nin fonksiyonlar arasında bilgi saklanmasını zorladığını hatırlayınız
				 //bu sebepten fonksiyonlar arası dizi aktarımı aşşağıdaki gibi yapılır:
				                 
				swap(&array[j], &array[j+1]);//* & birbirinin eşleniği olduğunu hatırlayalım,
			}                                //burada & konulmazsa fonksiyona diziler atanamaz.
		}            
	}
}


void swap(int *element1Ptr, int *element2Ptr){//değerler belirteç olarak atanmış.
	
	int hold=*element1Ptr;//değerleri yerine adresleri kullanılmış.
	*element1Ptr=*element2Ptr;
	*element2Ptr=hold;
}
*/
//Fonksiyonlar arası değişken atamasını belirteç olmadan deneyelim:



/*
#define SIZE 10
void bubbleSort(int array[], int size);

int main(){
	
	int a[SIZE] = {2, 6, 4, 8, 10, 12, 89, 68, 45, 37};
	
	puts("Data items in original order");
	
	for(int i=0; i<SIZE; ++i){
		
		printf("%4d", a[i]);
	}
	
	bubbleSort(a, SIZE);
	
	puts("\nData items in ascending order");
	
	for(int i=0; i<SIZE; ++i){
		
		printf("%4d", a[i]);
	}
	
	puts("\n");
}

void bubbleSort(int array[], int size){
	
	void swap(int elemnt1Ptr, int element2Ptr);
	
	for(int pass=0; pass<size-1; ++pass){
		
		for(int j=0; j<size-1; ++j){
			
			if(array[j]>array[j+1]){
				                 
				swap(array[j], array[j+1]);
			}                                
		}            
	}
}

void swap(int element1Ptr, int element2Ptr){
	
	int hold=element1Ptr;
	element1Ptr=element2Ptr;
	element2Ptr=hold;
}
*/
//Gördüğünüz üzere değişken korunmadığı için bubblesort algoritması sıralama yapamadı
//ve dizi yine orjinal halinde yazdırıldı. 



//====================================SIZEOF OPERATOR====================================================

/*
#define SIZE 20        //sizeof operatörü dizi isimlerine uygulandığında dizideki byte sayısını belirtir.

size_t getSize(const float *ptr);

int main(){
	
	float array[SIZE];
	                                        //Bu ifade, array dizisi içinde kaç byte olduğunu bulur 
printf("Number of bytes in the array is %zu\n", sizeof(array));//dizi büyüklüğü (bytes)
printf("Number of bytes returned by getSize is %zu\n", getSize(array));//yürütülen karakter boyutu (bytes)
	
}

size_t getSize(const float *ptr){
	
	return sizeof(ptr);
}
*/


//sizeof kullanım:
/*
int main(){
	
	char c;
	short s= 0;
	int i = 0;
	long l = 0;
	long long ll = 0;
	float f = 0.0F;
	double d = 0.0;
	long double ld = 0.0;
	int array[1] = {0};
	int *ptr = array;
	
	
 printf(" sizeof c = %2zu \t\t sizeof(char) = %2zu\n", sizeof c, sizeof(char));
 
 printf(" sizeof s = %2zu \t\t sizeof(short) = %2zu\n", sizeof s, sizeof(short));
 
 printf(" sizeof i = %2zu \t\t sizeof(int) = %2zu\n",sizeof i, sizeof(int));
 
 printf(" sizeof l = %2zu \t\t sizeof(long) = %2zu\n", sizeof l, sizeof(long));
 
 printf(" sizeof ll = %2zu \t sizeof(long long) = %2zu\n", sizeof ll, sizeof(long long));
 
 printf(" sizeof f = %2zu \t\t sizeof(float) = %2zu\n", sizeof f, sizeof(float));
 
 printf(" sizeof d = %2zu \t\t sizeof(double) = %2zu\n",sizeof d, sizeof(double));
 
 printf(" sizeof ld = %2zu \t sizeof(long double) = %2zu\n", sizeof ld, sizeof(long double));

 printf(" sizeof array = %2zu \n sizeof ptr = %2zu\n", sizeof array, sizeof ptr);
 	
}
*/

//=======================================================================================================

//dizi elemanlarını atamanın 4 metodu:


/*
#define ARRAY_SIZE 4

int main(){
	
	int method[] = {10, 20, 30, 40};
	int *methodPtr = method;
	
	
	//1.yol da klasik değer ataması kullanılmış.
	puts("Array method printed with:\nArray subscript notation");
	
	for(size_t i = 0; i<ARRAY_SIZE; ++i){
		
		printf("method[%zu] = %d\n", i, method[i]);
	}
	
	
	
	//2.yol da pointer ancak değer ile çağırma yöntemi kullanılmış
	puts("\nPointer/offset notation where the pointer is the array name");
	
	for(size_t offset = 0; offset<ARRAY_SIZE; ++offset){
		
		printf("*(method + %zu) = %d\n", offset, *(method+offset));
	}
	
	
	
	
	//3.yolda pointer kullanılmış. 
	puts("\nPointer subscript notation");
	
	for(size_t i=0; i<ARRAY_SIZE; ++i){
		
		printf("methodPtr[%zu] = %d\n", i, methodPtr[i]);
	}
	
	
	
	
	//4.yolda pointer ancak referans ile çağırma yöntemi kullanılmış.
	puts("\nPointer/offset notation");
	
	for(size_t offset=0; offset<ARRAY_SIZE; ++offset){
		
		printf("*(methodPtr + %zu) = %d\n", offset, *(methodPtr + offset));
	}
}
*/


/*
#define SIZE 10

void copy1(char*const s1, const char*const s2);
void copy2(char *s1, const char *s2);

int main(){
	
char string1[SIZE];//dizi atandı.
char *string2 = "Hello";//diziye eleman atandı ancak pointer(değer) kullanıldı.
	
copy1(string1, string2);//fonksiyona dizi atandı//copy1 fonksiyonuna atanan elemanlar
printf("string1 = %s\n", string1);//char tipinde değişmez(const) olarak atandı.ayrıca pointer kullanıldı.
                                  //atanma tipindeki ayrıntılara dikkat edin!	
	
	
	
char string3[SIZE];//dizi atandı.
char string4[] = "Good Bye";//diziye eleman atandı ancak değer ataması yapıldı.
	
copy2(string3, string4);//copy2 fonksiyonuna atanan elemanlar char tipinde ilk eleman değişebilir,
printf("string3 = %s\n", string3);//ikince eleman değişmez(const) olarak atandı ve bu atamada 
}                                 //pointer kullanıldı.



void copy1(char*const s1, const char*const s2){
	
for(size_t i=0; (s1[i] = s2[i]) != NULL; ++i){//for a atanmış diziler dizi sonu elemanına kadar 
		;                                    //çalıştırıldı.bu şekilde s2 s1e kopyalandı!
	}
}

void copy2(char *s1, const char *s2){
	
for(; (*s1 = *s2) != NULL; ++s1, ++s2){//for a atanmış diziler dizi sonu elemanına kadar çalıştırıldı.
		;                             //bu şekilde s4 s3e kopyalandı!
	}
}
*/




#define SUITS 4
#define FACES 13
#define CARDS 52

void shuffle(int deck[][FACES]);
void deal(int deck[][FACES], const char *face[], const char *suit[]);

int main(){
	
	int deck[SUITS][FACES] = {0};
	
	srand(time(NULL));
	
	shuffle(deck);//fonksiyona atla.
	
	const char *suit[SUITS] = {"Hearts", "Diamonds", "Clubs", "Spades"};
	//değişmeyen dizi, adres ile referansa göre elemanları atanmış.
	
	const char *face[FACES] = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven",
	"Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	//değişmeyen dizi, adres ile referansa göre elemanları atanmış.
	
	deal(deck, face, suit);//fonksiyona atla.
}


void shuffle(int deck[][FACES]){//iki boyutlu dizi ataması.
	
	for(size_t card = 1; card <=CARDS; ++card){//for döngüsü 52 defa dönüyor.
		
		size_t row = 0;
		size_t column = 0;
		
		do{
			row = rand()%SUITS;//4 tür kart var dizinin ana elemanlarından 4 ü rastgele seçiliyor(satır)
			column = rand()%FACES;//4 ana elemanın alt elemanları 13 adet rastgele seçiliyor(sütun)
		}while(deck[row][column] != 0);//while döngüsüyle bu koşul sonsuz hale getirilmiş.
		
		deck[row][column] = card;//1-13 eşitliği sağlanmış while için.
	}
}


void deal(int deck[][FACES], const char *face[], const char *suit[]){
	
	for(size_t card = 1; card <= CARDS; ++card){
		
		for(size_t row = 0; row < SUITS; ++row){
			
			for(size_t column = 0; column < FACES; ++column){
				
				if(deck[row][column] == card){
					printf("%5s of %-8s  %c", face[column], suit[row], card%4 == 0, "?  :" );
				}
			}//iki boyutlu dizi olduğu için çift for ile yazdırılma yapılmak zorunda.
		}//deck dizisinin geçerli elemanı card(1-13) eşitliği sağlandığında yazdırma yapılıyor.
	}
}

















































































































































































