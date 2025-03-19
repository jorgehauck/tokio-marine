package br.com.tokiomarine.seguradora.dto;

public class ApiResponseDTO {
    private MetaDTO meta;
    private ResultDTO result;
    public MetaDTO getMeta() {
        return meta;
    }
    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }
    public ResultDTO getResult() {
        return result;
    }
    public void setResult(ResultDTO result) {
        this.result = result;
    }
}
