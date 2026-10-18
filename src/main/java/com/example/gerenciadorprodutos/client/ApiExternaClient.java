package com.example.gerenciadorprodutos.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiExternaClient {

    @GET("ws/{cep}/json/")
    Call<EnderecoResponse> consultarCep(@Path("cep") String cep);
}
