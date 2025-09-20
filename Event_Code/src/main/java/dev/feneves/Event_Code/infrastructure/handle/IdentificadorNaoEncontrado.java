package dev.feneves.Event_Code.infrastructure.handle;

public class IdentificadorNaoEncontrado extends RuntimeException{
    public IdentificadorNaoEncontrado(String mensagem){
        super(mensagem);
    }

}
