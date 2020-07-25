package sda.advanced;

//Utwórz klasę UnderageException dziedziczącą po klasie exception. Stwórz klasę AgeValidator z metodą validate,
//która po otrzymaniu LocalDate z datą urodzenia sprawdzi czy dana osoba jest pełnoletnia na dzisiejszy dzień.
//Jeżeli tak to powinna zostać wydrukowana wiadomość o byciu pełnoletnim. Jeżeli nie, to powinien zostać rzucony powyższy wyjątek.

import java.time.LocalDate;
import java.time.Period;

public class AgeValidator {
    public static void validate(LocalDate date) throws UnderageException {
        int age = Period.between(date, LocalDate.now()).getYears();
        if(age >= 18){
            System.out.println("Person is not under aged");
        }else{
            throw new UnderageException("Person is under aged");
        }
    }
}
