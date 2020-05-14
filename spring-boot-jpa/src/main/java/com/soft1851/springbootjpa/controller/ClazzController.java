package com.soft1851.springbootjpa.controller;

import com.soft1851.springbootjpa.model.Clazz;
import com.soft1851.springbootjpa.repository.ClazzRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName ClazzController
 * @Description TODO
 * @date 2020-05-14 17:25
 **/
@RestController
@RequestMapping(value = "/api/clazz")
public class ClazzController {
    @Resource
    private ClazzRepository clazzRepository;

    @GetMapping("/{id}")
    public Clazz getClazz(@PathVariable int id){
        return clazzRepository.findClazzByIdEquals(id);
    }
}
