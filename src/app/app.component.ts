import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EstadosService } from './services/estados/estados.service';
import { PaisesService } from './services/paises/paises.service';
import { PersonaService } from './services/persona/persona.service';
import { error } from 'console';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrls: ['./app.component.css'], // Asegúrate de que sea `styleUrls`
})

export class AppComponent implements OnInit {
  personaForm!: FormGroup;
  paises:any;
  estados:any;

  constructor(
    public fb: FormBuilder,
    public estadosService: EstadosService,
    public paisesService: PaisesService,
    public personaService: PersonaService
  ) {}

  ngOnInit(): void {
    this.personaForm = this.fb.group({
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      edad: ['', Validators.required],
      pais: ['', Validators.required],
      estado: ['', Validators.required],
    });

    this.paisesService.getAllPaises().subscribe(resp=>
    {
      this.paises = resp;
      console.log(resp);
    },
    error=>{console.error(error)}
    )
  }

  guardar(): void {
    if (this.personaForm?.valid) {
      console.log('Formulario válido:', this.personaForm.value);
    } else {
      console.error('Formulario no válido');
    }
  }

  cargarEstadosPorPaisesId(event: any) {
    const paisId = event.target.value;
    console.log('País seleccionado:', paisId);
  
    if (paisId) {
      this.estadosService.getAllEstadosByPais(paisId).subscribe(
        resp => {
          this.estados = resp;
          console.log('Estados cargados:', resp);
        },
        error => console.error('Error al cargar estados:', error)
      );
    }
  }
  
}