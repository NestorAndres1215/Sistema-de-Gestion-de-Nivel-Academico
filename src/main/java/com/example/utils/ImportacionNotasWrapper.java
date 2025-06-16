package com.example.utils;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "notas")
public class ImportacionNotasWrapper {

    private List<NotaXML> notas;

    @XmlElement(name = "nota")
    public List<NotaXML> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaXML> notas) {
        this.notas = notas;
    }
}