package lt.akademija.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademija.Model.CreateRecordCmd;
import lt.akademija.Model.Record;
import lt.akademija.Service.RecordService;

@RestController
@Api(value = "Record")
@RequestMapping(value = "/api")
public class RecordController {
	
	@Autowired
	private RecordService recordService;
	
	@GetMapping(value = "/records")
	@ApiOperation(value = "Get list of all records", notes = "Returns list of all records")
	public List<Record> getRecords(@ApiParam(value = "Search record")
										@RequestParam(value = "search", required = false) String search ) {
		return recordService.getRecords(search);
	}
	
	@GetMapping(value = {"/records/{id}", "/admin/records/{id}"})
	@ApiOperation(value = "Get record", notes = "Returns record by id")
	public Record getRecord(@PathVariable String id) {
		return recordService.getRecord(id);
	}
	
	@PostMapping(value = "/admin/records/new")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create record", notes = "Creates record user")
	public void createRecord(@RequestBody CreateRecordCmd cmd) {
		recordService.createRecord(cmd);
	}
	
	@PutMapping(value = "/admin/records/{id}")
	@ApiOperation(value = "Update record", notes = "Updates record user details")
	public void updateRecord(@RequestBody CreateRecordCmd cmd, @PathVariable String id) {
		recordService.updateRecord(cmd, id);
	}
	
	@DeleteMapping(value = "/admin/records/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete record", notes = "Deletes record user")
	public void deleteRecord(@PathVariable String id) {
		recordService.deleteRecord(id);
	}

}
