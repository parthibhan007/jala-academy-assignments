import { Component } from '@angular/core';
import { bootstrapApplication } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';

interface AssignmentSection {
  number: number;
  title: string;
  description: string;
  items: string[];
  file: string;
  category: 'html' | 'css' | 'js' | 'angular';
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="site-wrapper">
      <header class="site-header">
        <div class="header-inner">
          <div class="header-title">
            <h1>Frontend Assignment</h1>
            <p>HTML &bull; CSS &bull; JavaScript &bull; AngularJS</p>
          </div>
          <div class="header-meta">
            <span class="badge">15 Topics Covered</span>
          </div>
        </div>
      </header>

      <nav class="filter-nav">
        <button
          *ngFor="let cat of categories"
          [class.active]="activeFilter === cat.value"
          (click)="activeFilter = cat.value"
          class="filter-btn">
          {{ cat.label }}
        </button>
      </nav>

      <main class="main-content">
        <div class="sections-grid">
          <a
            *ngFor="let section of getFilteredSections()"
            [href]="section.file"
            target="_blank"
            class="section-card"
            [class.html-card]="section.category === 'html'"
            [class.css-card]="section.category === 'css'"
            [class.js-card]="section.category === 'js'"
            [class.angular-card]="section.category === 'angular'">

            <div class="card-header">
              <span class="section-number">{{ section.number }}</span>
              <span class="category-tag" [class]="'tag-' + section.category">
                {{ getCategoryLabel(section.category) }}
              </span>
            </div>

            <h2 class="card-title">{{ section.title }}</h2>
            <p class="card-description">{{ section.description }}</p>

            <ul class="card-items">
              <li *ngFor="let item of section.items">{{ item }}</li>
            </ul>

            <div class="card-footer">
              <span class="open-link">Open Page &#8594;</span>
            </div>
          </a>
        </div>
      </main>

      <footer class="site-footer">
        <p>Frontend Assignment &bull; HTML / CSS / JavaScript / AngularJS</p>
        <p class="footer-note">Organized into folders: html/ &bull; css/ &bull; js/ &bull; angular/</p>
      </footer>
    </div>
  `,
  styles: [`
    * { box-sizing: border-box; margin: 0; padding: 0; }

    .site-wrapper {
      min-height: 100vh;
      background: #f1f5f9;
      font-family: Arial, sans-serif;
      color: #333;
    }

    .site-header {
      background: #1e4a70;
      color: white;
      padding: 0;
    }
    .header-inner {
      max-width: 1200px;
      margin: 0 auto;
      padding: 24px 30px;
      display: flex;
      align-items: center;
      justify-content: space-between;
      flex-wrap: wrap;
      gap: 12px;
    }
    .header-title h1 {
      font-size: 28px;
      font-weight: bold;
      margin: 0;
    }
    .header-title p {
      font-size: 15px;
      color: #b8d4ee;
      margin-top: 4px;
    }
    .badge {
      background: #f59e0b;
      color: #333;
      padding: 6px 14px;
      border-radius: 20px;
      font-weight: bold;
      font-size: 14px;
    }

    .filter-nav {
      background: #2c5f8a;
      padding: 10px 30px;
      display: flex;
      gap: 8px;
      flex-wrap: wrap;
    }
    .filter-btn {
      background: transparent;
      color: #cde4f8;
      border: 1px solid #4a7fa0;
      padding: 6px 16px;
      border-radius: 20px;
      cursor: pointer;
      font-size: 14px;
      font-weight: bold;
      transition: background 0.2s, color 0.2s;
    }
    .filter-btn:hover { background: #1e4a70; color: white; }
    .filter-btn.active { background: #f59e0b; color: #333; border-color: #f59e0b; }

    .main-content {
      max-width: 1200px;
      margin: 0 auto;
      padding: 30px;
    }

    .sections-grid {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
      gap: 20px;
    }

    .section-card {
      background: white;
      border-radius: 10px;
      border: 1px solid #ddd;
      text-decoration: none;
      color: inherit;
      display: flex;
      flex-direction: column;
      transition: transform 0.2s, box-shadow 0.2s;
      overflow: hidden;
      border-top: 4px solid #ddd;
    }
    .section-card:hover {
      transform: translateY(-4px);
      box-shadow: 0 8px 24px rgba(0,0,0,0.12);
    }
    .html-card { border-top-color: #e06b00; }
    .css-card  { border-top-color: #1e90ff; }
    .js-card   { border-top-color: #f0b429; }
    .angular-card { border-top-color: #c0392b; }

    .card-header {
      display: flex;
      align-items: center;
      justify-content: space-between;
      padding: 14px 16px 0;
    }
    .section-number {
      width: 32px;
      height: 32px;
      background: #1e4a70;
      color: white;
      border-radius: 50%;
      display: flex;
      align-items: center;
      justify-content: center;
      font-weight: bold;
      font-size: 14px;
    }
    .category-tag {
      font-size: 12px;
      font-weight: bold;
      padding: 3px 10px;
      border-radius: 10px;
    }
    .tag-html { background: #fff0e0; color: #e06b00; }
    .tag-css  { background: #e0f0ff; color: #1465b8; }
    .tag-js   { background: #fff8e0; color: #a07000; }
    .tag-angular { background: #fde8e8; color: #c0392b; }

    .card-title {
      font-size: 17px;
      font-weight: bold;
      color: #1e4a70;
      padding: 10px 16px 4px;
    }
    .card-description {
      font-size: 13px;
      color: #666;
      padding: 0 16px 8px;
      line-height: 1.5;
    }
    .card-items {
      padding: 0 16px 12px 32px;
      list-style: disc;
      flex: 1;
    }
    .card-items li {
      font-size: 13px;
      color: #555;
      margin-bottom: 3px;
    }
    .card-footer {
      border-top: 1px solid #eee;
      padding: 10px 16px;
    }
    .open-link {
      font-size: 13px;
      font-weight: bold;
      color: #2c5f8a;
    }
    .section-card:hover .open-link { color: #e06b00; }

    .site-footer {
      background: #1e4a70;
      color: #cde4f8;
      text-align: center;
      padding: 20px;
      font-size: 14px;
    }
    .site-footer p { margin: 4px 0; }
    .footer-note { color: #7aafd4; font-size: 13px; }

    @media (max-width: 600px) {
      .header-inner { padding: 16px 16px; }
      .main-content { padding: 16px; }
      .filter-nav { padding: 8px 16px; }
      .sections-grid { grid-template-columns: 1fr; }
    }
  `]
})
export class App {
  activeFilter: string = 'all';

  categories = [
    { value: 'all', label: 'All Topics' },
    { value: 'html', label: 'HTML' },
    { value: 'css', label: 'CSS' },
    { value: 'js', label: 'JavaScript' },
    { value: 'angular', label: 'AngularJS' },
  ];

  sections: AssignmentSection[] = [
    {
      number: 1,
      title: 'HTML Basics',
      description: 'Core HTML elements including headings, text, links, images, lists, and internal navigation.',
      items: ['Headings & paragraphs', 'Bold & italic text', 'Links & images', 'Ordered & unordered lists', 'div & span', 'Anchor navigation', 'Hover pseudo-class'],
      file: 'assets/html/1_basics.html',
      category: 'html'
    },
    {
      number: 2,
      title: 'HTML Forms',
      description: 'Complete HTML form with all major input types, attributes, iframe, and marquee.',
      items: ['Textbox, password, email', 'Radio & checkbox', 'Date, range, file upload', 'required, min, max attrs', 'iframe & marquee'],
      file: 'assets/html/2_forms.html',
      category: 'html'
    },
    {
      number: 3,
      title: 'HTML5 Semantic Elements',
      description: 'Semantic HTML5 structure with header, nav, section, article, aside, footer and more.',
      items: ['header, nav, main, footer', 'section, article, aside', 'figure, figcaption, mark, time', 'hgroup', 'HTML4 vs HTML5', 'div vs span'],
      file: 'assets/html/3_semantic.html',
      category: 'html'
    },
    {
      number: 4,
      title: 'CSS Basics',
      description: 'Fundamental CSS properties for backgrounds, borders, sizing, typography, and alignment.',
      items: ['Background color & image', 'Different border styles per side', 'Height & width', 'Font family/size/weight', 'Text alignment', 'Hover pseudo-class'],
      file: 'assets/css/4_css_basics.html',
      category: 'css'
    },
    {
      number: 5,
      title: 'CSS Layout',
      description: 'Responsive layout with CSS Grid, hero image, table layouts, list styles, and media queries.',
      items: ['Hero image section', 'table-layout fixed & auto', 'CSS Grid (2-col, 3-col, asymmetric)', 'List style types', 'Media queries & viewport', 'Responsive image & video'],
      file: 'assets/css/5_css_layout.html',
      category: 'css'
    },
    {
      number: 6,
      title: 'CSS Effects',
      description: 'Visual effects including shadows, animations, position properties, overflow, and opacity.',
      items: ['Box & image shadow', 'Hover effects', 'CSS animations (name/duration/delay/iteration)', 'Pagination styles', 'static/relative/absolute/fixed/sticky', 'Overflow scroll', 'Opacity'],
      file: 'assets/css/6_css_effects.html',
      category: 'css'
    },
    {
      number: 7,
      title: 'CSS Advanced',
      description: 'Page adjustment techniques including display vs visibility, box model, and smooth scrolling.',
      items: ['display vs visibility', 'padding vs margin', 'Multiple background images', 'Smooth scrolling', 'CSS Box Model', 'Sticky navigation'],
      file: 'assets/css/7_css_advanced.html',
      category: 'css'
    },
    {
      number: 8,
      title: 'JavaScript Basics',
      description: 'Core JavaScript concepts with live interactive demos for each topic.',
      items: ['Comments (single & multi-line)', 'Array sorting', 'for/in loop', 'Object property access', 'Hoisting', 'Strict mode'],
      file: 'assets/js/8_js_basics.html',
      category: 'js'
    },
    {
      number: 9,
      title: 'JavaScript Events',
      description: 'Event handling, form validation, cookies, console debugging, and JSON access.',
      items: ['addEventListener (date/time)', 'Form validation', 'console.log debugging', 'Set/get/check cookies', 'JSON + dot notation'],
      file: 'assets/js/9_js_events.html',
      category: 'js'
    },
    {
      number: 10,
      title: 'JavaScript Advanced',
      description: 'Advanced JS concepts: this, call/apply, closures, getters/setters, and prototypes.',
      items: ['this keyword', 'call() and apply()', 'Counter (closure)', 'Getter & setter', 'Prototype'],
      file: 'assets/js/10_js_advanced.html',
      category: 'js'
    },
    {
      number: 11,
      title: 'AngularJS Basics',
      description: 'AngularJS fundamentals with expressions, two-way data binding with ng-model, and controllers.',
      items: ['{{ }} expressions', 'ng-model (two-way binding)', 'Controller', '$scope', 'Live input binding demo'],
      file: 'assets/angular/11_ng_basics.html',
      category: 'angular'
    },
    {
      number: 12,
      title: 'AngularJS JSON',
      description: 'Display JSON data in tables with ng-repeat, sorting filters, and ng-options comparison.',
      items: ['JSON table with ng-repeat', '$index, $odd, $even', 'orderBy filter (sorting)', 'ng-options vs ng-repeat'],
      file: 'assets/angular/12_ng_json.html',
      category: 'angular'
    },
    {
      number: 13,
      title: 'AngularJS Events',
      description: 'Event directives including ng-click, ng-mousemove, ng-show, ng-hide, and ng-disabled.',
      items: ['ng-click with $event', 'ng-mousemove tracking', 'ng-show & ng-hide', 'ng-disabled', 'DOM, Events & MySQL explained'],
      file: 'assets/angular/13_ng_events.html',
      category: 'angular'
    },
    {
      number: 14,
      title: 'AngularJS Forms',
      description: 'Complete form with AngularJS validation: required, email, custom validators.',
      items: ['Text, select, checkbox, radio', 'required validation', 'email validation', 'min/max custom validation', 'Disable submit when invalid'],
      file: 'assets/angular/14_ng_forms.html',
      category: 'angular'
    },
    {
      number: 15,
      title: 'AngularJS Routing',
      description: 'Single-page app with ng-route, $routeProvider, otherwise(), and ng-animate transitions.',
      items: ['$routeProvider config', 'ng-view', 'otherwise() fallback', 'Animated route transitions', 'ng-show/ng-hide animations'],
      file: 'assets/angular/15_ng_routing.html',
      category: 'angular'
    }
  ];

  getFilteredSections(): AssignmentSection[] {
    if (this.activeFilter === 'all') return this.sections;
    return this.sections.filter(s => s.category === this.activeFilter);
  }

  getCategoryLabel(cat: string): string {
    const map: Record<string, string> = { html: 'HTML', css: 'CSS', js: 'JavaScript', angular: 'AngularJS' };
    return map[cat] || cat;
  }
}

bootstrapApplication(App);
