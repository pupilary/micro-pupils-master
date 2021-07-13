package com.pupils.provider.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pupils.provider.model.query.TableQuery;
import com.pupils.provider.model.vo.TableVo;
import com.pupils.provider.service.GeneratorTableService;
import com.pupils.web.controller.BaseController;
import com.pupils.web.metadata.PageInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author takesi
 * @date 2021-07-10
 */
@RestController
@RequestMapping(value = "/generator")
public class GeneratorController extends BaseController {

    @Autowired
    private GeneratorTableService generatorTableService;

    @GetMapping(value = "/list")
    public PageInfo list(TableQuery query) {
        IPage<TableVo> result = generatorTableService.queryList(query);
        return PageInfo
                .builder()
                .setCurrent(result.getCurrent())
                .setSize(result.getSize())
                .setTotal(result.getTotal())
                .setPages(result.getPages())
                .setData(result.getRecords())
                .build();
    }


    @GetMapping(value = "/download")
    public void downloadCode(String tables, HttpServletResponse response) throws IOException {
        byte[] data = generatorTableService.generatorCode(tables.split(","));
        response.reset();
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=");
        response.setHeader(HttpHeaders.CONTENT_LENGTH, "" + data.length);
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        IOUtils.write(data, response.getOutputStream());
    }

}
