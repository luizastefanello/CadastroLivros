package com.example.cadastrolivros.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.cadastrolivros.helper.SQLiteDataHelper;
import com.example.cadastrolivros.model.Livro;

public class CadastroDao implements IGenericDao<Livro>{
    //Abrir a conexão com o banco
    private SQLiteDataHelper openHelper;

    //Base de dados
    private SQLiteDatabase baseDados;

    //Nome das colunas
    private String[]colunas = {"NOME", "AUTOR", "EDITORA", "ANO", "GENERO","DESCRICAO"};

    //Nome da tabela
    private String tabela = "LIVROS";

    private Context context;

    private static CadastroDao instancia;

    public static CadastroDao getInstance(Context context){
        if(instancia == null){
            instancia = new CadastroDao(context);
        }
        return instancia;
    }

    private CadastroDao(Context context){
        this.context = context;

        openHelper = new SQLiteDataHelper(this.context, "CADASTROLIVROS_BD", null, 1);

        baseDados = openHelper.getWritableDatabase();
    }

    //agora aqui seria para inserir os dados
}
