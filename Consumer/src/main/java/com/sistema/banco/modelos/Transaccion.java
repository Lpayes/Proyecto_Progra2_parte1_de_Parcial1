package com.sistema.banco.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaccion {
	private String idTransaccion;
    private double monto;
    private String moneda;
    private String cuentaOrigen;
    private String bancoDestino;
    private Detalle detalle; 
    private String carnet; 
    private String nombre;
    private String correo;

    public String getIdTransaccion() { return idTransaccion; }
    public void setIdTransaccion(String idTransaccion) { this.idTransaccion = idTransaccion; }

    public String getCarnet() { return carnet; }
    public void setCarnet(String carnet) { this.carnet = carnet; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }

    public String getCuentaOrigen() { return cuentaOrigen; }
    public void setCuentaOrigen(String cuentaOrigen) { this.cuentaOrigen = cuentaOrigen; }

    public String getBancoDestino() { return bancoDestino; }
    public void setBancoDestino(String bancoDestino) { this.bancoDestino = bancoDestino; }

    public Detalle getDetalle() { return detalle; }
    public void setDetalle(Detalle detalle) { this.detalle = detalle; }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detalle {
        private String nombreBeneficiario;
        private String tipoTransferencia;
        private String descripcion;
        private Referencias referencias; 

        public String getNombreBeneficiario() { return nombreBeneficiario; }
        public void setNombreBeneficiario(String n) { this.nombreBeneficiario = n; }
        public String getTipoTransferencia() { return tipoTransferencia; }
        public void setTipoTransferencia(String t) { this.tipoTransferencia = t; }
        public String getDescripcion() { return descripcion; }
        public void setDescripcion(String d) { this.descripcion = d; }
        public Referencias getReferencias() { return referencias; }
        public void setReferencias(Referencias r) { this.referencias = r; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Referencias {
        private String factura;
        private String codigoInterno;

        public String getFactura() { return factura; }
        public void setFactura(String f) { this.factura = f; }
        public String getCodigoInterno() { return codigoInterno; }
        public void setCodigoInterno(String c) { this.codigoInterno = c; }
    }
}