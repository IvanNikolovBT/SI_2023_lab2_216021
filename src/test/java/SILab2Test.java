import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private List<User> createList(User ... elems)
    {
        return new ArrayList<>(Arrays.asList(elems));
    }
    @Test
    void testEveryBranch()
    {
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
    }
    @Test
    void testMultiple()
    {
        //TXX
        RuntimeException ex;
        User prv=new User("Branche","ZdravoKakoSi?!#","palceholder@gmail.com");
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(null,createList(prv)));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FTX
        User vtor=new User("IvanNikolov",null,"drugar.ivan@gmail.com");
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(vtor,createList(prv)));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FFT
        User tret=new User("IvanNikolov","216021",null);
        ex=assertThrows(RuntimeException.class, ()->SILab2.function(tret,createList(prv)));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FFF
        User chetvrt=new User("IvanNikolov","216021","drugar.ivan@gmail.com");
        assertFalse(SILab2.function(chetvrt,createList(prv)));


    }
}