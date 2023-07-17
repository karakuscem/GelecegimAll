import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {
  // Parent'tan gelen veriler
  @Input() columns: string[] = [];
  @Input() data: any[] = [];
  @Input() detailExists: boolean = false;
  @Input() editExists: boolean = false;
  // Parent'a gönderilecek veriler
  @Output() onDeleteClick = new EventEmitter<any>();
  @Output() onEditClick = new EventEmitter<any>();
  @Output() onDetailClick = new EventEmitter<any>();

  pagedData: any[] = [];
  currentPage = 1;
  itemsPerPage = 10;

  // Objeleri diziye çevirir ve dizi olarak döndürür. (Örn: {id: 1, name: 'Ahmet'} => ['1', 'Ahmet'])
  getObjectValues(obj: any): any[] {
    return Object.entries(obj).map(([key, value]) => `${value}`);
  }

  // Id'yi parent'a gönderir.
  handleDetailClick(id: string): void {
    this.onDetailClick.emit(id);
  }

  // Silme işlemi için id'yi parenta gönderir ve datayı filtreleyerek güncel veriyi gösterir, sayfayı günceller.
  handleDeleteClick(id: string): void {
    this.onDeleteClick.emit(id);
    this.data = this.data.filter(item => item.id !== id);
    this.pageChanged(this.currentPage);
  }

  // Edit işlemi için id'yi parent'a gönderir.
  handleEditClick(id: string): void {
    this.onEditClick.emit(id);
  }

  // Sayfa değiştiğinde çalışır, sayfayı günceller.
  ngOnChanges(): void {
    this.pageChanged(this.currentPage);
  }

  // Sayfa değiştiğinde güncelleme fonksiyonu
  pageChanged(page: number): void {
    const startIndex = (page - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    this.pagedData = this.data.slice(startIndex, endIndex);
    this.currentPage = page;
    if (this.pagedData.length === 0 && this.currentPage > 1) {
      this.previousPage();
    }
  }

  // Sayfa değiştirme butonları
  previousPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.pageChanged(this.currentPage);
    }
  }

  nextPage(): void {
    if (this.currentPage < this.totalPages) {
      this.currentPage++;
      this.pageChanged(this.currentPage);
    }
  }

  // Toplam sayfa sayısını hesaplar.
  get totalPages(): number {
    return Math.ceil(this.data.length / this.itemsPerPage);
  }
}
