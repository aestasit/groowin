/*
 * Copyright (C) 2011-2015 Aestas/IT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aestasit.infrastructure.winrm.dsl

import com.aestasit.infrastructure.winrm.CommonOptions

import static groovy.lang.Closure.DELEGATE_FIRST

/**
 * Closure delegate that is used to collect all remote file copying options.
 * Remote copying is implemented on CIFS.
 *
 * @author Andrey Adamovich
 *
 */
class CopyOptionsDelegate extends CommonOptions {

  private final FileSetDelegate source = new FileSetDelegate()
  private final FileSetDelegate target = new FileSetDelegate()

  def from(@DelegatesTo(strategy = DELEGATE_FIRST, value = FileSetDelegate) Closure cl) {
    cl.delegate = source
    cl.resolveStrategy = DELEGATE_FIRST
    cl()
  }

  def into(@DelegatesTo(strategy = DELEGATE_FIRST, value = FileSetDelegate) Closure cl) {
    cl.delegate = target
    cl.resolveStrategy = DELEGATE_FIRST
    cl()
  }

  FileSetDelegate getSource() {
    source
  }

  FileSetDelegate getTarget() {
    target
  }

}