import { Component, OnInit } from '@angular/core';
import { LeaveListDto } from 'src/app/model/LeaveListDto';
import { LeavesDto } from 'src/app/model/LeavesDto';
import { ManagerService } from 'src/app/service/manager.service';

@Component({
  selector: 'app-updateleaverequest',
  templateUrl: './updateleaverequest.component.html',
  styleUrls: ['./updateleaverequest.component.css']
})
export class UpdateLeaveRequestComponent implements OnInit  {

  leaves: LeaveListDto[] = [];
  managerId: number | null = null; // Initially null until entered by the user
  showCard = false;
  selectedLeave: any = null;
  statusOptions = ['Approved', 'Rejected'];
  errorMessage: string | null = null;

  constructor(private leaveService: ManagerService) {}

  ngOnInit(): void {

  }

  fetchLeaves(): void {
    if (this.managerId !== null) {
      this.leaveService.getAllLeavesByManagerId(this.managerId).subscribe(
        (data: LeaveListDto[]) => {
          this.leaves = data;
          this.errorMessage = null; // Clear any error messages
        },
        (error: any) => {
          this.errorMessage = 'Error fetching leaves. Please check the Manager ID.';
          console.error('Error fetching leaves', error);
        }
      );
    }
  }

  openStatusCard(leave: any): void {
    this.selectedLeave = leave;
    this.showCard = true;
  }

  updateStatus(status: string): void {
    if (this.selectedLeave && this.managerId !== null) {
      this.leaveService.updateLeaveStatus(this.managerId, this.selectedLeave.leaveId, status)
        .subscribe(
          (updatedLeave: { leaveStatus: LeavesDto; }) => {
            this.selectedLeave.leaveStatus = updatedLeave.leaveStatus;
            this.showCard = false;
            alert("Leave Status Update Succesfull")
          },
          (error: any) => {
            console.error('Error updating leave status', error);
            alert("LeaveStatus Update Failed ")

    });
    }
  }



}
