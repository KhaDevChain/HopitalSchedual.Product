package com.az9s.hopital.Backend.api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az9s.hopital.Backend.entity.Hopital;
import com.az9s.hopital.Backend.service.HopitalService;
import com.az9s.hopital.Backend.utils.http.request.HopitalRequest;
import com.az9s.hopital.Backend.utils.http.response.BasicResponse;
import com.az9s.hopital.Backend.utils.http.response.HopitalResponse;
import com.az9s.hopital.Backend.utils.option.ActivateEnum;

@RestController
@RequestMapping("/api/hopital")
public class HopitalRestController {
    @Autowired
    @Qualifier("logicHopitalService")
    private HopitalService hopitalService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllHopitals() {
        return ResponseEntity.ok(
            new HopitalResponse("Successfully !", hopitalService.findAll())
        );
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(
            new HopitalResponse("Successfully !", hopitalService.findById(id))
        );
    }

    @PostMapping("/save")
    public ResponseEntity<?> login(@RequestBody HopitalRequest hopitalRequest) {
        if (hopitalRequest != null) {
            Hopital hopital = asignHopitalCreate(hopitalRequest);
            Hopital saved = hopitalService.saveHopital(hopital);
            return ResponseEntity.ok(
                new HopitalResponse("Lưu thông tin thành công", saved)
            );
        } else {
            return ResponseEntity.badRequest().body("Hopital is null");
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody HopitalRequest hopitalRequest) {
        if (hopitalRequest != null) {
            Hopital hopital = asignHopitalEdit(hopitalRequest);
            if (hopital == null) {
                return ResponseEntity.badRequest().body("Bệnh viện không tồn tại");
            }
            Hopital saved = hopitalService.saveHopital(hopital);
            return ResponseEntity.ok(
                new HopitalResponse("Cập nhật thông tin thành công", saved)
            );
        } else {
            return ResponseEntity.badRequest().body("Hopital is null");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody String id) {
        if (id != null && !id.isEmpty()) {
            Hopital hopital = hopitalService.findById(id);
            if (hopital != null) {
                hopital.setActivated(ActivateEnum.INACTIVE);
                return ResponseEntity.ok(
                    new BasicResponse("Deleted hopital successfully id is " + id, 200)
                );
            } else {
                return ResponseEntity.badRequest().body("Hopital not found");
            }
        } else {
            return ResponseEntity.internalServerError().body("Department not found");
        }
    }


    /**
     * asign hopital edit
     * @param hopitalRequest
     * @return
     */
    public Hopital asignHopitalEdit(HopitalRequest hopitalRequest) {
        Hopital hopital = null;
        if (hopitalRequest != null && hopitalRequest.getUniqueId() != null) {
            hopital = hopitalService.findById(hopitalRequest.getUniqueId());
            if (hopital != null) {
                hopital.setName(hopitalRequest.getName());
                hopital.setCode(hopitalRequest.getCode());
                hopital.setAddress(hopitalRequest.getAddress());
                hopital.setEmail(hopitalRequest.getEmail());
                hopital.setType(hopitalRequest.getTypeEnum());
                hopital.setTaxCode(hopitalRequest.getTaxCode());
                hopital.setWebsite(hopitalRequest.getWebsite());
                hopital.setOpenWork(hopitalRequest.getOpenWork());
                hopital.setCloseWork(hopitalRequest.getCloseWork());
                hopital.setLogo(hopitalRequest.getLogo());
                hopital.setContract(hopitalRequest.getContract());
                hopital.setRepresentName(hopitalRequest.getRepresentName());
                hopital.setRepresentPhone(hopitalRequest.getRepresentPhone());
                hopital.setRepresentJob(hopitalRequest.getRepresentJob());
                hopital.setActivated(hopitalRequest.getActivatedEnum());
            }
        }
        return hopital;
    }

    /**
     * asign hopital create
     * @param hopitalRequest
     * @return
     */
    public Hopital asignHopitalCreate(HopitalRequest hopitalRequest) {
        Hopital hopital = new Hopital();
        if (hopitalRequest != null) {
            hopital.setUniqueId(UUID.randomUUID().toString());
            hopital.setName(hopitalRequest.getName());
            hopital.setCode(hopitalRequest.getCode());
            hopital.setAddress(hopitalRequest.getAddress());
            hopital.setEmail(hopitalRequest.getEmail());
            hopital.setType(hopitalRequest.getTypeEnum());
            hopital.setTaxCode(hopitalRequest.getTaxCode());
            hopital.setWebsite(hopitalRequest.getWebsite());
            hopital.setOpenWork(hopitalRequest.getOpenWork());
            hopital.setCloseWork(hopitalRequest.getCloseWork());
            hopital.setLogo(hopitalRequest.getLogo());
            hopital.setContract(hopitalRequest.getContract());
            hopital.setRepresentName(hopitalRequest.getRepresentName());
            hopital.setRepresentJob(hopitalRequest.getRepresentJob());
            hopital.setActivated(hopitalRequest.getActivatedEnum());
            hopital.setCreatedAt(LocalDateTime.now());
        }
        return hopital;
    }

}
