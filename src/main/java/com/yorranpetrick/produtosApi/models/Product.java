package com.yorranpetrick.produtosApi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //Mapeando classe como uma classe JPA
@Table(name = "Produtos") //A anotação só é necessária quando o nome da tabela é diferente do nome da classe de modelo de dados
public class Product {

    @Id //Informando que o atributo é Primary Key
    @Column(name = "code") //A anotação só é necessária quando o nome da coluna é diferente do nome do atributo
    private String id;
    private String name;
    private String description;
    private Double price;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price;
    }


}
