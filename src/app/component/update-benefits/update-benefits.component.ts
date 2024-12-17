import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Benefits } from 'src/app/model/Benefits';
import { PayrollProcessorService } from 'src/app/service/payroll-processor.service';

@Component({
  selector: 'app-update-benefits',
  templateUrl: './update-benefits.component.html',
  styleUrls: ['./update-benefits.component.css']
})
export class UpdateBenefitsComponent implements OnInit {
  benefit: Benefits = {
    benifitId: 0,
    benifitName: '',
    benefitAmount: 0
  };

  constructor(
    private service: PayrollProcessorService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const benifitId = +this.route.snapshot.paramMap.get('benefitId')!; // Retrieve the benefit ID from route parameters
    this.service.getBenefitById(benifitId).subscribe((data) => {
      this.benefit = data; // Initialize the benefit object with the fetched data
    });
  }

  updateBenefit(): void {
    this.service.updateBenefit(this.benefit.benifitId, this.benefit).subscribe(() => {
      console.log('Benefit updated successfully');
    });
  }
}
