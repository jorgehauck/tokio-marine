package br.com.tokiomarine.seguradora.dto;

import java.time.Instant;

public class ApiErrorResponseDTO {
    private MetaDTO meta;
    private ResultDTO result;
    private String path;

    public ApiErrorResponseDTO() {}
    public ApiErrorResponseDTO(MetaDTO meta, ResultDTO result, String path) {
        this.meta = meta;
        this.result = result;
        this.path = path;
    }
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
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}
