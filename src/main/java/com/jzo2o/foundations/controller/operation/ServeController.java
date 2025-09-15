package com.jzo2o.foundations.controller.operation;

import com.jzo2o.common.model.PageResult;
import com.jzo2o.foundations.model.dto.request.ServePageQueryReqDTO;
import com.jzo2o.foundations.model.dto.request.ServeUpsertReqDTO;
import com.jzo2o.foundations.model.dto.response.ServeResDTO;
import com.jzo2o.foundations.service.IServeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RestController("operationServeController")
@RequestMapping("/operation/serve")
@Api(tags = "运营端 - 服务相关接口")
public class ServeController {
    @Resource
    private IServeService serveService;

    @GetMapping("/page")
    @ApiOperation("运营端 - 服务分页查询")
    public PageResult<ServeResDTO> page(@ModelAttribute ServePageQueryReqDTO servePageQueryReqDTO) {

        return serveService.page(servePageQueryReqDTO);
    }

    @PostMapping("/batch")
    @ApiOperation("运营端 - 服务批量新增")
    public void batchAdd(@RequestBody List<ServeUpsertReqDTO> serveUpsertReqDTOList) {
        serveService.batchAdd(serveUpsertReqDTOList);
    }

    @PutMapping("/{id}")
    @ApiOperation("运营端 - 服务价格更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "服务id", required = true, paramType = "path"),
            @ApiImplicitParam(name = "price", value = "服务价格", required = true, paramType = "query")
    })
    public void updatePrice(@PathVariable Long id, BigDecimal price) {
        serveService.updatePrice(id, price);
    }

    @PutMapping("/onSale/{id}")
    @ApiOperation("运营端 - 服务上架")
    @ApiImplicitParam(name = "id", value = "服务id", required = true, paramType = "path")
    public void onSale(@PathVariable Long id) {
        serveService.onSale(id);
    }
}
