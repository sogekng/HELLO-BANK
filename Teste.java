enum Cores 

{

Vermelho, Verde, Azul, Amarela, Preta;  

}

public class UsaEnumeracao

{

public static void main(String[] args) 

{

for (Cores c : Cores.values())

System.out.println(c + " - " + c.ordinal());    

}

}

