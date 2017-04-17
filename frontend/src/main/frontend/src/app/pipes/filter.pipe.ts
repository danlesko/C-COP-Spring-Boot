import { Pipe, PipeTransform, Injectable } from '@angular/core';
@Pipe({
  name: 'filter'
})
@Injectable()
export class FilterPipe implements PipeTransform {
  transform(items: any[], field : string, value : string): any[] {
    if (value == '' || value == null) return items;
    if (!items) return [];
    return items.filter(item => {return ((String(item[field]).toUpperCase().substring(0,String(value).length)) === (String(value).toUpperCase())) });
  }
}
