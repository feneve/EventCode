package dev.feneves.Event_Code.infrastructure.handle;

public class DupplicateIdentificador extends RuntimeException{
    public DupplicateIdentificador(String mensagem){
         super(mensagem);
    }
}
