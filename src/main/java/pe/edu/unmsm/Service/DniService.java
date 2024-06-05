package pe.edu.unmsm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import pe.edu.unmsm.Model.DniModel;
import pe.edu.unmsm.Model.DniRequest;
import pe.edu.unmsm.Model.DniResponse;
import pe.edu.unmsm.Repository.DniRepository;

@Service
public class DniService {

    private final RestTemplate restTemplate;
    private final DniRepository dniRepository;


    @Autowired
    public DniService(RestTemplate restTemplate, DniRepository dniRepository) {
        this.restTemplate = restTemplate;
        this.dniRepository = dniRepository;
    }

    public DniResponse getDniData(String dni) {
        String url = "https://apiperu.dev/api/dni";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer 939ced66ba09a604d9c6232cd679b9daa39d0360da43ce235be288216376ecb6");

        DniRequest dniRequest = new DniRequest(dni);
        HttpEntity<DniRequest> requestEntity = new HttpEntity<>(dniRequest, headers);

        ResponseEntity<DniResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, DniResponse.class);

        DniResponse dniResponse = responseEntity.getBody();
        try {
            saveDniDataInDatabase(dniResponse);

        } catch (DataIntegrityViolationException e) {

        }

        return dniResponse;
    }

    private void saveDniDataInDatabase(DniResponse dniResponse) {
        DniModel dniData = new DniModel();
        dniData.setNumero(dniResponse.getData().getNumero());
        dniData.setNombre_completo(dniResponse.getData().getNombre_completo());
        dniData.setNombres(dniResponse.getData().getNombres());
        dniData.setApellido_paterno(dniResponse.getData().getApellido_paterno());
        dniData.setApellido_materno(dniResponse.getData().getApellido_materno());
        dniData.setCodigo_verificacion(dniResponse.getData().getCodigo_verificacion());

        dniRepository.save(dniData);
    }
}
