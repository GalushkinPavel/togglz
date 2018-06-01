package com.example.togglz;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

import javax.servlet.http.HttpServletRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

import static com.example.togglz.MyFeatures.FEATURE_ONE;
import static com.example.togglz.MyFeatures.FEATURE_TWO;

@RestController
public class MyController {
    private FeatureManager manager;

    public MyController(FeatureManager manager) {
        this.manager = manager;
    }

    @GetMapping("/myapp")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(manager.isActive(FEATURE_ONE) + "; " + manager.isActive(FEATURE_TWO));
    }

    @GetMapping("/ip")
    public ResponseEntity<?> ip(HttpServletRequest request) {
        return ResponseEntity.ok(request.getRemoteAddr());
    }

    @GetMapping("/ips")
    public ResponseEntity<?> ips() throws UnknownHostException {
        Set<String> localhostAddresses = new HashSet<>();
        localhostAddresses.add(InetAddress.getLocalHost().getHostAddress());
        return ResponseEntity.ok(localhostAddresses);
    }

    @GetMapping("/check")
    public ResponseEntity<?> check() {
        String sb =
                "First Feature is active: " + FEATURE_ONE.isActive() +
                ";\t" +
                "Second Feature is active: " + FEATURE_TWO.isActive();
        return ResponseEntity.ok(sb);
    }
}
