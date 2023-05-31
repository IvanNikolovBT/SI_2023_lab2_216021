Име Иван
Презиме Николов
Индекс 216021


3. Цикломатската комплекснот на добиениот CFG е 11. Имаме 10 под региони и 1 надворешен регион.

4.

Целата excel табеала е прикачена во посебен фајл.
Вредностите што ги користам се:

a=user=null , [ (IvanNikolov,216021,drugar.ivan@gmail.com),(NikolaIvanov,120612,ivan.drugar@gmail.com…)]
b=(null,216021@!#,drugar.ivan@gmail.com),[(drugar.ivan@gmail.com,216021@!#,drugar.ivan@gmail.com),(Branche,  ZdravoKakoSi?!! ,placeholder@gmail.com,)]
c=(IvanNikolov,216021OvaEMojotIndeks,LoshEmejl),[(Branche,ZdravoKakoSi?!#,palceholder@gmail.com)]
d=(IvanNikolov,Ivan,drugar.ivan@gmail.com),[(Branche,ZdravoKakoSi?!#,palceholder@gmail.com)]
e=(IvanNikolov,Ivan Najak,OlesnitelenLoshMejl),[(Branche,ZdravoKakoSi?!#,palceholder@gmail.com)]
 
Со помош на влезот A тестирам дали се внесени потребните информации. Го добивам errorot Mandatory informationg missing!

Со помош на влезот B правам повеќе тестови, како што е и евидентно во самата excel табела. Тоа го правам со помош на листата
каде што имам повеќе корисници и тие влегуваат во повеке if услови.

Со помош на влезот C влегуваме во паткетата каде што имаме невалиден мејл и прескокнуваме голем дел од кодот и стигнуваме до последниот false.

Со помош на влезот D враќаме назад false, затоа што внесуваме невалиден пасворд.

Со помош на влезот E стигаме до последниот for, но никогаш не влегуваме затоа што имаме празно место во пасвордот. 

Точните вредности што се искористени се следните:
 	    RuntimeException ex;
        User eden=new User("IvanNikolov","216021","drugar.ivan@gmail.com");
        User dva=new User("NikolaIvanov","120612","ivan.drugar@gmail.com");
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(null,createList(eden,dva)));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        User tri=new User(null,"216021@!#","drugar.ivan@gmail.com");
        User chetiri=new User("drugar.ivan@gmail.com","216021@!#","drugar.ivan@gmail.com");
        User pet=new User("Branche", " ZdravoKakoSi?!!" ,"placeholder@gmail.com");
        assertFalse(SILab2.function(tri,createList(chetiri,pet)));

        User shes=new User("IvanNikolov","216021OvaEMojotIndeks","LoshEmejl");
        User sedum=new User("Branche","ZdravoKakoSi?!#","palceholder@gmail.com");
        assertFalse(SILab2.function(shes,createList(sedum)));

        User osum=new User("IvanNikolov","Ivan","drugar.ivan@gmail.com");
        User devet=new User("Branche","ZdravoKakoSi?!#","palceholder@gmail.com");
        assertFalse(SILab2.function(osum,createList(devet)));

        User deset=new User("IvanNikolov","Ivan Najak","OlesnitelenLoshMejl");
        User edinaeset=new User("Branche","ZdravoKakoSi?!#","palceholder@gmail.com");
        assertFalse(SILab2.function(deset,createList(edinaeset)));

5.

if (user==null || user.getPassword()==null || user.getEmail()==null)	Вредности
TXX									null,[(Branche,ZdravoKakoSi?!#,palceholder@gmail.com)]
FTX									(IvanNikolov,null,drugar.ivan@gmail.com),[(Branche,ZdravoKakoSi?!#,palceholder@gmail.com)]
FFT									(IvanNikolov,216021,null),[(Branche,ZdravoKakoSi?!#,palceholder@gmail.com)]
FFF									(IvanNikolov,216021,drugar.ivan@gmail.com),[(Branche,ZdravoKakoSi?!#,palceholder@gmail.com)]

Со помош на првиот случај го тестираме TXX. Добиваме  Mandatory information missing!  што е и посакуваното однесување.

Со помош на вториот случај го тестираме FTX. Добиваме  Mandatory information missing!  што е и посакуваното однесување.

Со помош на третиот случај го тестираме FFT. Добиваме  Mandatory information missing!  што е и посакуваното однесување.

Со помош на четвртиот случај го тестираме FFF. Добиваме false кое што е посакуваното однесвуање.

