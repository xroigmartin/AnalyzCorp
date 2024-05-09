import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FinancialDataRoutingModule } from './financial-data-routing.module';
import {FinancialDataPageComponent} from "./pages/financial-data-page/financial-data-page.component";
import {BalanceSheetComponent} from "./components/balance-sheet/balance-sheet.component";
import {CashFlowStatementComponent} from "./components/cash-flow-statement/cash-flow-statement.component";
import {IncomeStatementComponent} from "./components/income-statement/income-statement.component";
import {PrimgNgModule} from "../primg-ng/primg-ng.module";


@NgModule({
  declarations: [
    FinancialDataPageComponent,
    BalanceSheetComponent,
    CashFlowStatementComponent,
    IncomeStatementComponent
  ],
  imports: [
    CommonModule,
    FinancialDataRoutingModule,
    PrimgNgModule
  ]
})
export class FinancialDataModule { }
