package pe.edu.unmsm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.Model.DniModel;
import pe.edu.unmsm.Model.DniRequest;
import pe.edu.unmsm.Model.DniResponse;
import pe.edu.unmsm.Repository.DniRepository;
import pe.edu.unmsm.Service.DniService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DniController {

    private final DniRepository dniRepository;
    private final DniService dniService;

    @Autowired
    public DniController(DniService dniService, DniRepository dniRepository) {
        this.dniService = dniService;
        this.dniRepository = dniRepository;
    }

    @PostMapping("/dni")
    public DniResponse getDniData(@RequestBody DniRequest dniRequest) {
        return dniService.getDniData(dniRequest.getDni());
    }

    @GetMapping("/dni")
    public List<DniModel> getDniData() {
        return dniRepository.findAll();
    }
}
