import { TestBed } from '@angular/core/testing';

import { AdminHrManagerService } from './admin-hr-manager.service';

describe('AdminHrManagerService', () => {
  let service: AdminHrManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminHrManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
