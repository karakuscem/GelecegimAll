import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent {
  // Parent'dan verilecek filtre seçenekleri
  @Input() filterOptions: string[] = [];
  filterBy: string = '';
  filterValue: string = '';
  // Parent'a gönderilecek obje
  @Output() applyFilterEvent = new EventEmitter<any>();
  @Output() clearFilterEvent = new EventEmitter<any>();
  // Filtreleme işlemi için objeyi parent'a gönderir.
  applyFilter(obj: any) {
    this.applyFilterEvent.emit(obj);
  }
  // Filtreleme işlemi için objeyi parent'a gönderir.
  clearFilter() {
    this.filterBy = '';
    this.filterValue = '';
    this.clearFilterEvent.emit();
  }
}
