import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module'; // Verifique se está correto
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router'; // Adicione esta importação se necessário

@NgModule({
  declarations: [
    AppComponent,
    FormsModule, 
    AppRoutingModule
    // Declare seus componentes aqui
  ],
  imports: [
    BrowserModule,
    FormsModule, // Necessário para [(ngModel)]
    AppRoutingModule, // Certifique-se de que está importado
    RouterModule // Adicione esta importação se necessário
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
