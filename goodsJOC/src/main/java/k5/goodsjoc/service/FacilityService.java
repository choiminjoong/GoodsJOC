package k5.goodsjoc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Shelf;
import k5.goodsjoc.dto.Showcase;
import k5.goodsjoc.dto.Warehouse;
import k5.goodsjoc.mapper.FacilityMapper;

@Service
@Transactional
public class FacilityService {
		private final FacilityMapper facilityMapper;
		public FacilityService(FacilityMapper facilityMapper) {
			this.facilityMapper = facilityMapper;
		}
		
		
		public List<Warehouse> getWarehouseList(String martCode){
			return facilityMapper.getWarehouseList(martCode);
		}
		
		public List<Showcase> getShowcaseList(String martCode){
			return facilityMapper.getShowcaseList(martCode);
		}
		
		public List<Warehouse> getWarehouseListByMartCode(String martCode) {
			return facilityMapper.getWarehouseListByMartCode(martCode);
		}

		
		public int warehouseInsert(Warehouse warehouse) {
			return facilityMapper.warehouseInsert(warehouse);
		}

		public int shelfInsert(Shelf shelf) {
			return facilityMapper.shelfInsert(shelf);
		}

		public int showcaseInsert(Showcase showcase) {
			return facilityMapper.showcaseInsert(showcase);
		}
}
