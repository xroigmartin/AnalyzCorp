import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FinancialDataPageComponent} from "./pages/financial-data-page/financial-data-page.component";

const routes: Routes = [
  {
    path:'',
    component: FinancialDataPageComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FinancialDataRoutingModule { }
