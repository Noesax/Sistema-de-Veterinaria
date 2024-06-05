package pe.edu.unmsm.Model;

public class DniResponse {

    private boolean success;
    private Data data;

    public static class Data {
        private String numero;
        private String nombre_completo;
        private String nombres;
        private String apellido_paterno;
        private String apellido_materno;
        private String codigo_verificacion;

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public String getNombre_completo() {
            return nombre_completo;
        }

        public void setNombre_completo(String nombre_completo) {
            this.nombre_completo = nombre_completo;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getApellido_paterno() {
            return apellido_paterno;
        }

        public void setApellido_paterno(String apellido_paterno) {
            this.apellido_paterno = apellido_paterno;
        }

        public String getApellido_materno() {
            return apellido_materno;
        }

        public void setApellido_materno(String apellido_materno) {
            this.apellido_materno = apellido_materno;
        }

        public String getCodigo_verificacion() {
            return codigo_verificacion;
        }

        public void setCodigo_verificacion(String codigo_verificacion) {
            this.codigo_verificacion = codigo_verificacion;
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
