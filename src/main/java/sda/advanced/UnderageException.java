package sda.advanced;

//Utwórz klasę UnderageException dziedziczącą po klasie exception. Stwórz klasę AgeValidator z metodą validate,
//która po otrzymaniu LocalDate z datą urodzenia sprawdzi czy dana osoba jest pełnoletnia na dzisiejszy dzień.
//Jeżeli tak to powinna zostać wydrukowana wiadomość o byciu pełnoletnim. Jeżeli nie, to powinien zostać rzucony powyższy wyjątek.

public class UnderageException extends Exception {
    public UnderageException(String person_is_under_aged) {
        super(person_is_under_aged);
    }
}
