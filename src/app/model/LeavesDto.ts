export interface LeavesDto{

    empId:number;
    startDate:Date;
    endDate:Date;
    leaveType:string;
    managerID:{
        managerId :number;
    }
}