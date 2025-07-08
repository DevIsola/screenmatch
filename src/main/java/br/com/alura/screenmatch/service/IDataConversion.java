package br.com.alura.screenmatch.service;

public interface IDataConversion {
    <T> T convertData(String json, Class<T> type) throws Exception;
}
