package fr.simplon.domedespuys.views;

public class AddressView {
    public interface Id {}
    public interface Line {}
    public interface ExtraLine {}
    public interface City {}
    public interface ZipCode {}
    public interface Country {}
    public interface Phone {}
    public interface Firstname {}
    public interface Lastname {}
    public interface CreatedAt{}
    public interface User {}
    public interface AddressListView extends
            Line,
            ExtraLine,
            City,
            ZipCode,
            Country,
            Phone,
            Firstname,
            Lastname
    {}



}
