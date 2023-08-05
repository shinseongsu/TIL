package org.example.membership.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.example.membership.application.port.out.FindMembershipPort;
import org.example.membership.application.port.out.RegisterMembershipPort;
import org.example.membership.common.PersistenceAdapter;
import org.example.membership.domain.Membership;
import org.springframework.stereotype.Repository;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        return membershipRepository.save(
            new MembershipJpaEntity(
                    membershipName.getMembershipName(),
                    membershipEmail.getMembershipEmail(),
                    membershipAddress.getMembershipAddress(),
                    membershipIsValid.isMembershipIsValid(),
                    membershipIsCorp.isMembershipIsCorp()
            )
        );
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
    }
}
