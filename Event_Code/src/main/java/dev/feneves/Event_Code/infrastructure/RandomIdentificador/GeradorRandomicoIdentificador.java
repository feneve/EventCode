package dev.feneves.Event_Code.infrastructure.RandomIdentificador;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class GeradorRandomicoIdentificador {
    public final String letras ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final String numeros ="0123456789";
    public final SecureRandom RANDOM = new SecureRandom();

    public GeradorRandomicoIdentificador(){};

    public  String generate(){
        List<Character> identificador = new ArrayList<>();
        identificador.addAll(charrandomicosunicos(letras,3));
        identificador.addAll(charrandomicosunicos(numeros,4));
        Collections.shuffle(identificador,RANDOM);
        StringBuilder builder = new StringBuilder();
        for (char x : identificador){
            builder.append(x);
        }
        return builder.toString();
    }

    public List<Character>charrandomicosunicos(String source,int count){
        List<Character> random = new ArrayList<>();
        for (char x : source.toCharArray()){
            random.add(x);
        }
        Collections.shuffle(random,RANDOM);
        return random.subList(0,count);
    }
}
