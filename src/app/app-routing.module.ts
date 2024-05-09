import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'financial-data',
    pathMatch: 'full',
  },
  {
    path: 'financial-data',
    loadChildren: () => import('./financial-data/financial-data.module').then(m => m.FinancialDataModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
