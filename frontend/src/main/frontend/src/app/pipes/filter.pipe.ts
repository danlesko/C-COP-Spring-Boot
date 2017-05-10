// Created by Dan Lesko
// Used to filter data in our frontend filters
// This class checks to see if a passed in string matches a substring in a JSON object key

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
