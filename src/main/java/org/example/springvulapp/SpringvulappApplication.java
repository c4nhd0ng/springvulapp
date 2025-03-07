package org.example.springvulapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.management.ManagementFactory;
import java.io.File;
@SpringBootApplication
public class SpringvulappApplication {

    public static void main(String[] args) {
//        Log4jBypass.patchLog4j(); //khong hoat dong
//        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true"); //khong hoat dong
//        System.setProperty("com.sun.jndi.cosnaming.object.trustURLCodebase", "true"); //khong hoat dong
//        attachJavaAgent("log4j-agent.jar"); khong hoat dong
        SpringApplication.run(SpringvulappApplication.class, args);
    }

//    private static void attachJavaAgent(String agentPath) {
//        try {
//            // Lấy PID của JVM hiện tại
//            String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
//
//            // Load VirtualMachine class từ Attach API
//            Class<?> vmClass = Class.forName("com.sun.tools.attach.VirtualMachine");
//            Object vm = vmClass.getMethod("attach", String.class).invoke(null, pid);
//
//            // Load Java Agent vào JVM
//            vmClass.getMethod("loadAgent", String.class).invoke(vm, new File(agentPath).getAbsolutePath());
//
//            // Detach VirtualMachine
//            vmClass.getMethod("detach").invoke(vm);
//
//            System.out.println("🚀 Java Agent loaded successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
