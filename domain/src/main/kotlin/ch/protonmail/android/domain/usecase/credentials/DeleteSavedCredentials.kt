/*
 * Copyright (c) 2020 Proton Technologies AG
 *
 * This file is part of ProtonMail.
 *
 * ProtonMail is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ProtonMail is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ProtonMail. If not, see https://www.gnu.org/licenses/.
 */

package ch.protonmail.android.domain.usecase.credentials

import ch.protonmail.android.domain.entity.EmailAddress
import ch.protonmail.android.domain.repository.CredentialRepository
import kotlinx.coroutines.withContext
import me.proton.core.util.kotlin.DispatcherProvider
import javax.inject.Inject

/**
 * Delete a stored credential by [EmailAddress]
 */
class DeleteSavedCredentials @Inject constructor (
    private val dispatchers: DispatcherProvider,
    private val repository: CredentialRepository
) {

    suspend operator fun invoke(emailAddress: EmailAddress) = withContext(dispatchers.Io) {
        repository -= emailAddress
    }
}
